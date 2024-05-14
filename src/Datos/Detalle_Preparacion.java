package Datos;

public class Detalle_Preparacion {
    private int id;
    private int cantidad;
    private PreparacionAlimento objPA;
    private Producto objP;

    public Detalle_Preparacion() {
    }

    public Detalle_Preparacion(int id, int cantidad, PreparacionAlimento objPA, Producto objP) {
        this.id = id;
        this.cantidad = cantidad;
        this.objPA = objPA;
        this.objP = objP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public PreparacionAlimento getObjPA() {
        return objPA;
    }

    public void setObjPA(PreparacionAlimento objPA) {
        this.objPA = objPA;
    }

    public Producto getObjP() {
        return objP;
    }

    public void setObjP(Producto objP) {
        this.objP = objP;
    }
    
}
