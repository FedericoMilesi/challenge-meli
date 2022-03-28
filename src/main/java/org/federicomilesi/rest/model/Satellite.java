package org.federicomilesi.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Satellite {
    //Atributos
    private String name;
    private double xCoordinate;
    private double yCoordinate;
    private double distanceFromShip;
    private String[] receivedMessage;
    //Constructores
    public Satellite() {

    }
    //Constructor para generar un satélite en el recurso topsecret_split
    public Satellite(double distanceFromShip, String[] receivedMessage) {
        this.name = "";
        this.xCoordinate = 0.0;
        this.yCoordinate = 0.0;
        this.distanceFromShip = distanceFromShip;
        this.receivedMessage = new String[5];
        this.receivedMessage = receivedMessage;
    }
    //Constructor para generar un satélite en el recurso topsecret
    public Satellite(String name, double distanceFromShip, String[] receivedMessage) {
        this.name = name;
        this.xCoordinate = 0.0;
        this.yCoordinate = 0.0;
        this.distanceFromShip = distanceFromShip;
        this.receivedMessage = new String[5];
        this.receivedMessage = receivedMessage;
    }
    //Getters y setters
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getXCoordinate() {
        return this.xCoordinate;
    }
    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }
    public double getYCoordinate() {
        return this.yCoordinate;
    }
    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
    public double getDistanceFromShip() {
        return this.distanceFromShip;
    }
    public void setDistanceFromShip(double distanceFromShip) {
        this.distanceFromShip = distanceFromShip;
    }
    public String[] getReceivedMessage() {
        return this.receivedMessage;
    }
    public void setReceivedMessage(String[] receivedMessage) {
        this.receivedMessage = receivedMessage;
    }
}