package Datos;

public class Personal {

    private int id;
    private String nombre;
    private String apellido;
    private String nro_documento;
    private int estado;
    private Documento idDocumento;
    private Cargo idCargo;

    public Personal() {
    }

    public Personal(int id, String nombre, String apellido, String nro_documento, int estado, Documento idDocumento, Cargo idCargo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nro_documento = nro_documento;
        this.estado = estado;
        this.idDocumento = idDocumento;
        this.idCargo = idCargo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNro_documento() {
        return nro_documento;
    }

    public void setNro_documento(String nro_documento) {
        this.nro_documento = nro_documento;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Documento getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Documento idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Cargo getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Cargo idCargo) {
        this.idCargo = idCargo;
    }
    
    @Override
    public String toString() {
        return nombre + " " + apellido;
    }

}
