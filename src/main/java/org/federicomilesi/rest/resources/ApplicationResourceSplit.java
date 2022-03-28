package org.federicomilesi.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.federicomilesi.rest.model.Satellite;
import org.federicomilesi.rest.service.ApplicationService;

@Path("/topsecret_split")
public class ApplicationResourceSplit {
    ApplicationService service = new ApplicationService();
    @POST
    @Path("/{satelliteName}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addSatellite(@PathParam("satelliteName") String name, Satellite satellite) {
        return this.service.addSatellite(name, satellite);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String GetLocation() {
        return this.service.GetLocation();
    }
}
