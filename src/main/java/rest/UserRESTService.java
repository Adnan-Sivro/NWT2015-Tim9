package rest;

import dbclasses.User;
import services.UserService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by XenoGearX on 24.3.2015.
 */

@Path("/users")
public class UserRESTService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUserInJSON() {
        UserService userService = new UserService();
        return userService.updateUser(1);
    }
}

