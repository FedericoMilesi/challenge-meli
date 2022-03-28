package org.federicomilesi.rest.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.federicomilesi.rest.model.Satellite;
import org.federicomilesi.rest.service.ApplicationService;

@Path("/topsecret")
public class ApplicationResource {
    ApplicationService service = new ApplicationService();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addSatellites(List<Satellite> satellites) {
        return this.service.addSatellites(satellites);
    }
}