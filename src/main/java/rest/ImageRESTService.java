package rest;

import dbclasses.Image;
import dbclasses.ResourceType;
import dbclasses.User;
import services.ImageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

/**
 * Created by Enes on 30.3.2015..
 */
@Path("/images")
public class ImageRESTService {

    @GET
    @Path("/getImage")
    @Produces(MediaType.APPLICATION_JSON)
    public Image updateImageInJSON() {
        ImageService imageService = new ImageService();
        return imageService.updateImage(1);
    }

    @POST
    @Path("/createImage")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createImageInJSON(Image image) throws URISyntaxException {
            Image newImage = new Image();
            newImage.setIdimage(image.getIdimage());
            newImage.setName(image.getName());
            newImage.setLocation(image.getLocation());
            newImage.setDescription(image.getDescription());
            newImage.setResourceTypeIdresourceType(image.getResourceTypeIdresourceType());

        return Response.status(200).entity("Image with ID: " + image.getIdimage() + " is created successfully").build();
    }

    @DELETE
    @Path("/deleteImage")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteImageInJSON(@QueryParam("idimage") int idimage) throws URISyntaxException {
        return Response.status(200).entity("Image with ID: " + idimage + " is deleted successfully").build();
    }
}
