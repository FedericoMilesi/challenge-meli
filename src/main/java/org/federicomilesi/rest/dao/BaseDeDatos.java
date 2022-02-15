package org.federicomilesi.rest.dao;

import java.util.ArrayList;
import java.util.List;
import org.federicomilesi.rest.modelo.Satelite;

public final class BaseDeDatos {
    private final static BaseDeDatos baseDeDatos = new BaseDeDatos();
    private final List<Satelite> satelites = new ArrayList<>();
    private BaseDeDatos() {

    }
    public static BaseDeDatos getInstancia() {
        return baseDeDatos;
    }
    public List<Satelite> getSatelites() {
        return this.satelites;
    }
}