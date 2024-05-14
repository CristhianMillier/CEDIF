package Datos;

public class UnidadMedida {
    private int id;
    private String nombre;
    private String abreviacion;
    private int estado;

    public UnidadMedida() {
    }

    public UnidadMedida(int id, String nombre, String abreviacion, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.abreviacion = abreviacion;
        this.estado = estado;
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

    public String getAbreviacion() {
        return abreviacion;
    }

    public void setAbreviacion(String abreviacion) {
        this.abreviacion = abreviacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return abreviacion;
    }
    
    
}
