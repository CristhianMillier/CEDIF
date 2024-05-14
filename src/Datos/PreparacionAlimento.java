package Datos;

public class PreparacionAlimento {
    private int id;
    private String descripcionAlimento;
    private String tipoAlmuerzo;
    private int etado;
    private String fecha_hora;
    private Personal objP;

    public PreparacionAlimento() {
    }

    public PreparacionAlimento(int id, String descripcionAlimento, String tipoAlmuerzo, int etado, Personal objP) {
        this.id = id;
        this.descripcionAlimento = descripcionAlimento;
        this.tipoAlmuerzo = tipoAlmuerzo;
        this.etado = etado;
        this.objP = objP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcionAlimento() {
        return descripcionAlimento;
    }

    public void setDescripcionAlimento(String descripcionAlimento) {
        this.descripcionAlimento = descripcionAlimento;
    }

    public String getTipoAlmuerzo() {
        return tipoAlmuerzo;
    }

    public void setTipoAlmuerzo(String tipoAlmuerzo) {
        this.tipoAlmuerzo = tipoAlmuerzo;
    }

    public int getEtado() {
        return etado;
    }

    public void setEtado(int etado) {
        this.etado = etado;
    }

    public Personal getObjP() {
        return objP;
    }

    public void setObjP(Personal objP) {
        this.objP = objP;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    @Override
    public String toString() {
        return descripcionAlimento + " (" + tipoAlmuerzo + ")";
    }
    
    
}
