package Datos;

import rsbuttom.RSButtonMetro;

public class Cargo {

    private int idCargo;
    private String nombre;
    private int estado;
    private RSButtonMetro dos7;
    private RSButtonMetro dos3;
    private RSButtonMetro dos2;
    private RSButtonMetro dos6;
    private RSButtonMetro dos1;
    private RSButtonMetro dos;
    private RSButtonMetro dos5;
    private RSButtonMetro dos9;
    private RSButtonMetro dos8;
    private RSButtonMetro dos4;

    public Cargo() {
    }

    public Cargo(int idCargo, String nombre, int estado) {
        this.idCargo = idCargo;
        this.nombre = nombre;
        this.estado = estado;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        this.idCargo = idCargo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
