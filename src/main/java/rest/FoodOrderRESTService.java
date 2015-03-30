package rest;

import dbclasses.FoodMenu;
import dbclasses.FoodOrder;
import dbclasses.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Enes on 30.3.2015..
 */
@Path("/orders")
public class FoodOrderRESTService {

    @GET
    @Path("/createOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrderInJSON(FoodOrder foodOrder) throws URISyntaxException {

        FoodOrder newFoodOrder = new FoodOrder();
        newFoodOrder.setIdfoodOrder(foodOrder.getIdfoodOrder());
        newFoodOrder.setOrderName(foodOrder.getOrderName());
        newFoodOrder.setOderDate(foodOrder.getOderDate());
        newFoodOrder.setAmount(foodOrder.getAmount());
        newFoodOrder.setOrderPrice(foodOrder.getOrderPrice());
        newFoodOrder.setFoodMenuIdfood(foodOrder.getFoodMenuIdfood());
        newFoodOrder.setUserIduser(foodOrder.getUserIduser());

        return Response.status(200).entity("User with ID: " + foodOrder.getIdfoodOrder() + " is created successfully").build();
    }

    @DELETE
    @Path("/deleteOrder")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteOrderInJSON(@QueryParam("idfoodOrder") int idfoodOrder) throws URISyntaxException {
        return Response.status(200).entity("Food Order with ID: " + idfoodOrder + " is deleted successfully").build();
    }

}
