package org.federicomilesi.rest.recursos;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.federicomilesi.rest.modelo.Satelite;
import org.federicomilesi.rest.servicio.AplicacionServicio;

@Path("/topsecret_split")
public class AplicacionRecursoSplit {
    AplicacionServicio servicio = new AplicacionServicio();
    @POST
    @Path("/{sateliteNombre}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addSatelite(@PathParam("sateliteNombre") String nombre, Satelite satelite) {
        return this.servicio.addSatelite(nombre, satelite);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String GetLocation() {
        return this.servicio.GetLocation();
    }
}
