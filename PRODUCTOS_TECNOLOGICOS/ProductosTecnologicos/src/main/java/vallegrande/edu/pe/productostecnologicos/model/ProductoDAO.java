package vallegrande.edu.pe.productostecnologicos.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public boolean registrarProducto(Producto producto) {
        String sql = "INSERT INTO productos (nombre, marca, modelo, categoria, precio, stock, garantia_meses) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getMarca());
            ps.setString(3, producto.getModelo());
            ps.setString(4, producto.getCategoria());
            ps.setDouble(5, producto.getPrecio());
            ps.setInt(6, producto.getStock());
            ps.setInt(7, producto.getGarantiaMeses());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al registrar: " + e.getMessage());
            return false;
        }
    }

    public List<Producto> listarProductos() {
        List<Producto> lista = new ArrayList<>();
        String sql = "SELECT * FROM productos";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Producto(rs.getInt("id_producto"), rs.getString("nombre"), rs.getString("marca"), rs.getString("modelo"), rs.getString("categoria"), rs.getDouble("precio"), rs.getInt("stock"), rs.getInt("garantia_meses")));
            }
        } catch (SQLException e) {
            System.err.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    public boolean actualizarProducto(Producto producto) {
        String sql = "UPDATE productos SET nombre=?, marca=?, modelo=?, categoria=?, precio=?, stock=?, garantia_meses=? WHERE id_producto=?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getMarca());
            ps.setString(3, producto.getModelo());
            ps.setString(4, producto.getCategoria());
            ps.setDouble(5, producto.getPrecio());
            ps.setInt(6, producto.getStock());
            ps.setInt(7, producto.getGarantiaMeses());
            ps.setInt(8, producto.getIdProducto());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarProducto(int idProducto) {
        String sql = "DELETE FROM productos WHERE id_producto=?";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idProducto);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
}