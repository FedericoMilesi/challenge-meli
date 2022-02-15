package org.federicomilesi.rest.modelo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Satelite {
    //Atributos
    private String nombre;
    private double coordenadaX;
    private double coordenadaY;
    private double distanciaAlEmisor;
    private String[] mensajeRecibido;
    //Constructores
    public Satelite() {

    }
    //Constructor para generar un satélite en el recurso topsecret_split
    public Satelite(double distanciaAlEmisor, String[] mensajeRecibido) {
        this.nombre = "";
        this.coordenadaX = 0.0;
        this.coordenadaY = 0.0;
        this.distanciaAlEmisor = distanciaAlEmisor;
        this.mensajeRecibido = new String[5];
        this.mensajeRecibido = mensajeRecibido;
    }
    //Constructor para generar un satélite en el recurso topsecret
    public Satelite(String nombre, double distanciaAlEmisor, String[] mensajeRecibido) {
        this.nombre = nombre;
        this.coordenadaX = 0.0;
        this.coordenadaY = 0.0;
        this.distanciaAlEmisor = distanciaAlEmisor;
        this.mensajeRecibido = new String[5];
        this.mensajeRecibido = mensajeRecibido;
    }
    //Getters y setters
    public String getNombre() {
        return this.nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getCoordenadaX() {
        return this.coordenadaX;
    }
    public void setCoordenadaX(double coordenadaX) {
        this.coordenadaX = coordenadaX;
    }
    public double getCoordenadaY() {
        return this.coordenadaY;
    }
    public void setCoordenadaY(double coordenadaY) {
        this.coordenadaY = coordenadaY;
    }
    public double getDistanciaAlEmisor() {
        return this.distanciaAlEmisor;
    }
    public void setDistanciaAlEmisor(double distanciaAlEmisor) {
        this.distanciaAlEmisor = distanciaAlEmisor;
    }
    public String[] getMensajeRecibido() {
        return this.mensajeRecibido;
    }
    public void setMensajeRecibido(String[] mensajeRecibido) {
        this.mensajeRecibido = mensajeRecibido;
    }
}