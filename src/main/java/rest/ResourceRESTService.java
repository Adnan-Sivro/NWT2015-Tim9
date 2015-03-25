package rest;

import dbclasses.Resource;
import services.ResourceService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Adnan on 25.3.2015..
 */
@Path("/resources")
public class ResourceRESTService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Resource updateResourceInJSON() {
        ResourceService resourceService = new ResourceService();
        return resourceService.updateResource(1);
    }

}