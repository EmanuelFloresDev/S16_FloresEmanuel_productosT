package vallegrande.edu.pe.productostecnologicos.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import vallegrande.edu.pe.productostecnologicos.model.Producto;

public class ProductoView {

    private VBox root;

    // Campos del formulario
    public TextField txtNombre = new TextField();
    public TextField txtMarca = new TextField();
    public TextField txtModelo = new TextField();
    public TextField txtCategoria = new TextField();
    public TextField txtPrecio = new TextField();
    public TextField txtStock = new TextField();
    public TextField txtGarantia = new TextField();

    // Botones
    public Button btnGuardar = new Button("Guardar");
    public Button btnActualizar = new Button("Actualizar");
    public Button btnEliminar = new Button("Eliminar");
    public Button btnLimpiar = new Button("Limpiar");
    public Button btnRefrescar = new Button("Refrescar Lista");

    // Tabla
    public TableView<Producto> tablaProductos = new TableView<>();

    public ProductoView() {
        construirInterfaz();
    }

    private void construirInterfaz() {
        root = new VBox(20);
        root.setPadding(new Insets(25, 30, 25, 30));
        root.setStyle("-fx-background-color: #f4f6f9; -fx-font-family: 'Segoe UI', Arial, sans-serif;");

        // Título
        Label lblTitulo = new Label("PRODUCTOS TECNOLÓGICOS");
        lblTitulo.setStyle("-fx-font-size: 22px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

        // Formulario (GridPane)
        GridPane grid = new GridPane();
        grid.setHgap(15);
        grid.setVgap(12);
        grid.setStyle("-fx-background-color: #ffffff; -fx-padding: 20; -fx-background-radius: 8; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.1), 10, 0, 0, 2);");

        String estiloInput = "-fx-background-radius: 4; -fx-border-color: #bdc3c7; -fx-border-radius: 4;";
        txtNombre.setStyle(estiloInput); txtMarca.setStyle(estiloInput);
        txtModelo.setStyle(estiloInput); txtCategoria.setStyle(estiloInput);
        txtPrecio.setStyle(estiloInput); txtStock.setStyle(estiloInput);
        txtGarantia.setStyle(estiloInput);

        grid.add(crearLabel("Nombre:"), 0, 0); grid.add(txtNombre, 1, 0);
        grid.add(crearLabel("Marca:"), 2, 0); grid.add(txtMarca, 3, 0);
        grid.add(crearLabel("Modelo:"), 0, 1); grid.add(txtModelo, 1, 1);
        grid.add(crearLabel("Categoría:"), 2, 1); grid.add(txtCategoria, 3, 1);
        grid.add(crearLabel("Precio ($):"), 0, 2); grid.add(txtPrecio, 1, 2);
        grid.add(crearLabel("Stock:"), 2, 2); grid.add(txtStock, 3, 2);
        grid.add(crearLabel("Garantía (Meses):"), 0, 3); grid.add(txtGarantia, 1, 3);

        // Botones
        HBox hboxBotones = new HBox(15);
        hboxBotones.setAlignment(Pos.CENTER_LEFT);

        btnGuardar.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5; -fx-padding: 8 15; -fx-cursor: hand;");
        btnActualizar.setStyle("-fx-background-color: #2980b9; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5; -fx-padding: 8 15; -fx-cursor: hand;");
        btnEliminar.setStyle("-fx-background-color: #c0392b; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5; -fx-padding: 8 15; -fx-cursor: hand;");
        btnLimpiar.setStyle("-fx-background-color: #7f8c8d; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 5; -fx-padding: 8 15; -fx-cursor: hand;");
        btnRefrescar.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #2c3e50; -fx-border-color: #bdc3c7; -fx-border-radius: 5; -fx-background-radius: 5; -fx-padding: 8 15; -fx-cursor: hand;");

        hboxBotones.getChildren().addAll(btnGuardar, btnActualizar, btnEliminar, btnLimpiar, btnRefrescar);

        // Tabla
        configurarTabla();
        VBox.setVgrow(tablaProductos, Priority.ALWAYS);

        root.getChildren().addAll(lblTitulo, grid, hboxBotones, tablaProductos);
    }

    private Label crearLabel(String texto) {
        Label lbl = new Label(texto);
        lbl.setStyle("-fx-text-fill: #34495e; -fx-font-weight: bold;");
        return lbl;
    }

    @SuppressWarnings("unchecked")
    private void configurarTabla() {
        tablaProductos.setStyle("-fx-background-radius: 8; -fx-border-color: #ecf0f1;");

        TableColumn<Producto, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("idProducto"));
        colId.setPrefWidth(50);

        TableColumn<Producto, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colNombre.setPrefWidth(150);

        TableColumn<Producto, String> colMarca = new TableColumn<>("Marca");
        colMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colMarca.setPrefWidth(100);

        TableColumn<Producto, String> colModelo = new TableColumn<>("Modelo");
        colModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        colModelo.setPrefWidth(120);

        TableColumn<Producto, String> colCategoria = new TableColumn<>("Categoría");
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colCategoria.setPrefWidth(120);

        TableColumn<Producto, Double> colPrecio = new TableColumn<>("Precio ($)");
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colPrecio.setPrefWidth(80);

        TableColumn<Producto, Integer> colStock = new TableColumn<>("Stock");
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
        colStock.setPrefWidth(60);

        TableColumn<Producto, Integer> colGarantia = new TableColumn<>("Garantía");
        colGarantia.setCellValueFactory(new PropertyValueFactory<>("garantiaMeses"));
        colGarantia.setPrefWidth(80);

        tablaProductos.getColumns().addAll(colId, colNombre, colMarca, colModelo, colCategoria, colPrecio, colStock, colGarantia);
    }

    public VBox getRoot() {
        return root;
    }

    public void mostrarMensajeExito(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Operación Exitosa");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void mostrarMensajeError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Atención");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}