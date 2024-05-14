package Datos;

public class Producto {
    private int id;
    private String descripcion;
    private int cantidad;
    private double precio;
    private String fecha_caduca;
    private int estado;
    private UnidadMedida objUM;
    private Categoria objC;
    private Marca objM;

    public Producto() {
    }

    public Producto(int id, String descripcion, int cantidad, double precio, String fecha_caduca, int estado, UnidadMedida objUM, Categoria objC, Marca objM) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fecha_caduca = fecha_caduca;
        this.estado = estado;
        this.objUM = objUM;
        this.objC = objC;
        this.objM = objM;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFecha_caduca() {
        return fecha_caduca;
    }

    public void setFecha_caduca(String fecha_caduca) {
        this.fecha_caduca = fecha_caduca;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public UnidadMedida getObjUM() {
        return objUM;
    }

    public void setObjUM(UnidadMedida objUM) {
        this.objUM = objUM;
    }

    public Categoria getObjC() {
        return objC;
    }

    public void setObjC(Categoria objC) {
        this.objC = objC;
    }

    public Marca getObjM() {
        return objM;
    }

    public void setObjM(Marca objM) {
        this.objM = objM;
    }

    @Override
    public String toString() {
        if (id != 0) {
            return objC.getNombre() + ": " + descripcion + " - " + objM.getNombre();
        } else{
            return descripcion;
        }
    }
    
}
