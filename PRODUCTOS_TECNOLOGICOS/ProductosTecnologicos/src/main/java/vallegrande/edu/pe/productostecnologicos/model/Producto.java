package vallegrande.edu.pe.productostecnologicos.model;

public class Producto {
    private int idProducto;
    private String nombre;
    private String marca;
    private String modelo;
    private String categoria;
    private double precio;
    private int stock;
    private int garantiaMeses;

    public Producto() {}

    public Producto(int idProducto, String nombre, String marca, String modelo, String categoria, double precio, int stock, int garantiaMeses) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
        this.garantiaMeses = garantiaMeses;
    }

    // Getters y Setters
    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
    public int getGarantiaMeses() { return garantiaMeses; }
    public void setGarantiaMeses(int garantiaMeses) { this.garantiaMeses = garantiaMeses; }
}