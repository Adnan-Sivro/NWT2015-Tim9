package rest;

import dbclasses.ResourceType;
import services.ResourceTypeService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Enes on 31.3.2015..
 */
@Path("resourcetype")
public class ResourceTypeRESTService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ResourceType updateResourceTypeInJSON() {
        ResourceTypeService resourceTypeService = new ResourceTypeService();
        return resourceTypeService.updateResourceType(1);
    }

}

