package Datos;

public class Proveedor {
    private int id;
    private String razonSocial;
    private String nrodocumento;
    private Documento objD;
    private int estado;

    public Proveedor() {
    }

    public Proveedor(int id, String razonSocial, String nrodocumento, Documento objD, int estado) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.nrodocumento = nrodocumento;
        this.objD = objD;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNrodocumento() {
        return nrodocumento;
    }

    public void setNrodocumento(String nrodocumento) {
        this.nrodocumento = nrodocumento;
    }

    public Documento getObjD() {
        return objD;
    }

    public void setObjD(Documento objD) {
        this.objD = objD;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return razonSocial;
    }
    
}
