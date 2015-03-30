package rest;


import dbclasses.FoodMenu;
import dbclasses.User;
import services.FoodMenuService;
import services.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

/**
 * Created by Adnan on 25.3.2015..
 */
@Path("/menus")
public class FoodMenuRESTService {


    @GET
    @Path("/getMenu")
    @Produces(MediaType.APPLICATION_JSON)
    public FoodMenu updateMenuInJSON() {
        FoodMenuService foodMenuService = new FoodMenuService();
        return foodMenuService.updateFoodMenu(1);
    }

    @POST
    @Path("/createMenu")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createMenuInJSON(FoodMenu foodMenu) throws URISyntaxException {

        return Response.status(200).entity("User with ID: " + foodMenu.getIdfood() + " is created successfully").build();
    }

    @DELETE
    @Path("/deleteMenu")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteMenuInJSON(@QueryParam("idfood") int idfood) throws URISyntaxException {
        return Response.status(200).entity("Menu with ID: " + idfood + " is deleted successfully").build();
    }


}
