package Datos;

public class Compra {
    private int id;
    private double pago;
    private String fecha;
    private int estado;
    private String nroComprobante;
    private byte[] documentoPDF;
    private Comprobante objComp;
    private Proveedor objProve;
    private Personal objPer;

    public Compra() {
    }

    public Compra(int id, double pago, String fecha, int estado, String nroComprobante, byte[] documentoPDF, Comprobante objComp, Proveedor objProve, Personal objPer) {
        this.id = id;
        this.pago = pago;
        this.fecha = fecha;
        this.estado = estado;
        this.nroComprobante = nroComprobante;
        this.documentoPDF = documentoPDF;
        this.objComp = objComp;
        this.objProve = objProve;
        this.objPer = objPer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNroComprobante() {
        return nroComprobante;
    }

    public void setNroComprobante(String nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    public byte[] getDocumentoPDF() {
        return documentoPDF;
    }

    public void setDocumentoPDF(byte[] documentoPDF) {
        this.documentoPDF = documentoPDF;
    }

    public Comprobante getObjComp() {
        return objComp;
    }

    public void setObjComp(Comprobante objComp) {
        this.objComp = objComp;
    }

    public Proveedor getObjProvee() {
        return objProve;
    }

    public void setObjProd(Proveedor objProve) {
        this.objProve = objProve;
    }

    public Personal getObjPer() {
        return objPer;
    }

    public void setObjPer(Personal objPer) {
        this.objPer = objPer;
    }

    @Override
    public String toString() {
        return objComp.getNombre() + " con Nro. " + nroComprobante + " con fecha " + fecha;
    }
    
}
