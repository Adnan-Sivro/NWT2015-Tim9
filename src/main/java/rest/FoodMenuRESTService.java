package rest;


import dbclasses.FoodMenu;
import services.FoodMenuService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Korisnik on 25.3.2015..
 */
@Path("/menus")
public class FoodMenuRESTService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public FoodMenu updateFoodMenuInJSON() {
        FoodMenuService foodmenuService = new FoodMenuService();
        return foodmenuService.updateFoodMenu(1);
    }
//com
}
