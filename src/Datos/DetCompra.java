package Datos;

public class DetCompra {
    private int id;
    private double precio;
    private int cantidad;
    private Compra objC;
    private Producto objP;
    private String caducidadProducto;

    public DetCompra() {
    }

    public DetCompra(int id, double precio, int cantidad, Compra objC, Producto objP) {
        this.id = id;
        this.precio = precio;
        this.cantidad = cantidad;
        this.objC = objC;
        this.objP = objP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Compra getObjC() {
        return objC;
    }

    public void setObjC(Compra objC) {
        this.objC = objC;
    }

    public Producto getObjP() {
        return objP;
    }

    public void setObjP(Producto objP) {
        this.objP = objP;
    }

    public String getCaducidadProducto() {
        return caducidadProducto;
    }

    public void setCaducidadProducto(String caducidadProducto) {
        this.caducidadProducto = caducidadProducto;
    }
    
}
