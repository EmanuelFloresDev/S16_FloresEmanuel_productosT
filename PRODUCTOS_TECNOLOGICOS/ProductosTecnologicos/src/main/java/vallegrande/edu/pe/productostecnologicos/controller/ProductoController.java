package vallegrande.edu.pe.productostecnologicos.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import vallegrande.edu.pe.productostecnologicos.model.Producto;
import vallegrande.edu.pe.productostecnologicos.model.ProductoDAO;
import vallegrande.edu.pe.productostecnologicos.view.ProductoView;

public class ProductoController {

    private final ProductoView view;
    private final ProductoDAO dao;
    private final ObservableList<Producto> listaProductos;
    private int idProductoSeleccionado = 0;

    public ProductoController(ProductoView view, ProductoDAO dao) {
        this.view = view;
        this.dao = dao;
        this.listaProductos = FXCollections.observableArrayList();

        inicializarEventos();
        cargarProductos();
    }

    private void inicializarEventos() {
        view.tablaProductos.setItems(listaProductos);

        // Asignar acciones a los botones de la vista
        view.btnGuardar.setOnAction(e -> guardarProducto());
        view.btnActualizar.setOnAction(e -> actualizarProducto());
        view.btnEliminar.setOnAction(e -> eliminarProducto());
        view.btnLimpiar.setOnAction(e -> limpiarCampos());
        view.btnRefrescar.setOnAction(e -> cargarProductos());

        // Evento al seleccionar una fila de la tabla
        view.tablaProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSel, newSel) -> {
            if (newSel != null) {
                llenarFormulario(newSel);
            }
        });
    }

    private void guardarProducto() {
        if (idProductoSeleccionado != 0) {
            view.mostrarMensajeError("Hay un producto seleccionado. Usa 'Actualizar' o presiona 'Limpiar' para registrar uno nuevo.");
            return;
        }
        try {
            Producto p = obtenerDatosDeFormulario();
            if (dao.registrarProducto(p)) {
                view.mostrarMensajeExito("Producto registrado correctamente.");
                limpiarCampos();
                cargarProductos();
            } else {
                view.mostrarMensajeError("No se pudo registrar en la base de datos.");
            }
        } catch (NumberFormatException e) {
            view.mostrarMensajeError("Por favor, verifica que Precio, Stock y Garantía sean números válidos.");
        }
    }

    private void actualizarProducto() {
        if (idProductoSeleccionado == 0) {
            view.mostrarMensajeError("Selecciona un producto de la tabla para actualizar.");
            return;
        }
        try {
            Producto p = obtenerDatosDeFormulario();
            p.setIdProducto(idProductoSeleccionado);
            if (dao.actualizarProducto(p)) {
                view.mostrarMensajeExito("Producto actualizado correctamente.");
                limpiarCampos();
                cargarProductos();
            } else {
                view.mostrarMensajeError("Error al actualizar el producto.");
            }
        } catch (NumberFormatException e) {
            view.mostrarMensajeError("Por favor, verifica que Precio, Stock y Garantía sean números válidos.");
        }
    }

    private void eliminarProducto() {
        if (idProductoSeleccionado == 0) {
            view.mostrarMensajeError("Selecciona un producto de la tabla para eliminar.");
            return;
        }
        if (dao.eliminarProducto(idProductoSeleccionado)) {
            view.mostrarMensajeExito("Producto eliminado correctamente.");
            limpiarCampos();
            cargarProductos();
        } else {
            view.mostrarMensajeError("Error al eliminar el producto.");
        }
    }

    private void cargarProductos() {
        listaProductos.clear();
        listaProductos.addAll(dao.listarProductos());
    }

    private void limpiarCampos() {
        view.txtNombre.clear();
        view.txtMarca.clear();
        view.txtModelo.clear();
        view.txtCategoria.clear();
        view.txtPrecio.clear();
        view.txtStock.clear();
        view.txtGarantia.clear();
        idProductoSeleccionado = 0;
        view.tablaProductos.getSelectionModel().clearSelection();
    }

    private Producto obtenerDatosDeFormulario() {
        Producto p = new Producto();
        p.setNombre(view.txtNombre.getText());
        p.setMarca(view.txtMarca.getText());
        p.setModelo(view.txtModelo.getText());
        p.setCategoria(view.txtCategoria.getText());
        p.setPrecio(Double.parseDouble(view.txtPrecio.getText()));
        p.setStock(Integer.parseInt(view.txtStock.getText()));
        p.setGarantiaMeses(Integer.parseInt(view.txtGarantia.getText()));
        return p;
    }

    private void llenarFormulario(Producto p) {
        idProductoSeleccionado = p.getIdProducto();
        view.txtNombre.setText(p.getNombre());
        view.txtMarca.setText(p.getMarca());
        view.txtModelo.setText(p.getModelo());
        view.txtCategoria.setText(p.getCategoria());
        view.txtPrecio.setText(String.valueOf(p.getPrecio()));
        view.txtStock.setText(String.valueOf(p.getStock()));
        view.txtGarantia.setText(String.valueOf(p.getGarantiaMeses()));
    }
}