package org.federicomilesi.rest.recursos;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.federicomilesi.rest.modelo.Satelite;
import org.federicomilesi.rest.servicio.AplicacionServicio;

@Path("/topsecret")
public class AplicacionRecurso {
    AplicacionServicio servicio = new AplicacionServicio();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addSatelites(List<Satelite> satelites) {
        return this.servicio.addSatelites(satelites);
    }
}