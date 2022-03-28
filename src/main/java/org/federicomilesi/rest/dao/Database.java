package org.federicomilesi.rest.dao;

import java.util.ArrayList;
import java.util.List;
import org.federicomilesi.rest.model.Satellite;

public final class Database {
    private final static Database database = new Database();
    private final List<Satellite> satellites = new ArrayList<>();
    private Database() {

    }
    public static Database getInstance() {
        return database;
    }
    public List<Satellite> getSatellites() {
        return this.satellites;
    }
}