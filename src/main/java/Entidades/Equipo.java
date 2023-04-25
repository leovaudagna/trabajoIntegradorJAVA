package Entidades;

import Enumeraciones.ResultadoEnum;

public class Equipo {

    private String nombre;
    private String descripcion;
    private boolean autorizacion = true;
    private ResultadoEnum resultadoEnElPartido;
    private int cantGolesEnElTorneo;

    public Equipo() {
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public Equipo(String nombre, String descripcion, boolean autorizacion, ResultadoEnum resultadoEnElPartido, int cantGolesEnElTorneo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.autorizacion = autorizacion;
        this.resultadoEnElPartido = resultadoEnElPartido;
        this.cantGolesEnElTorneo = cantGolesEnElTorneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(boolean autorizacion) {
        this.autorizacion = autorizacion;
    }

    public ResultadoEnum getResultadoEnElPartido() {
        return resultadoEnElPartido;
    }

    public void setResultadoEnElPartido(ResultadoEnum resultadoEnElPartido) {
        this.resultadoEnElPartido = resultadoEnElPartido;
    }

    public int getCantGolesEnElTorneo() {
        return cantGolesEnElTorneo;
    }

    public void setCantGolesEnElTorneo(int cantGolesEnElTorneo) {
        this.cantGolesEnElTorneo = cantGolesEnElTorneo;
    }

    public void sumarGolesNuevos(int nuevosGoles){
        this.cantGolesEnElTorneo += nuevosGoles;
    }
}
