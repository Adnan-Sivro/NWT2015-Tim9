package rest;

import dbclasses.User;
import services.UserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;
import java.sql.Timestamp;


/**
 * Created by XenoGearX on 24.3.2015.
 */

@Path("/users")

public class UserRESTService {
/*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUserInJSON() {
        UserService userService = new UserService();
        return userService.updateUser(1);
    }*/
/*
    @DELETE
    @Path("/delete/{iduser}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUserInJSON(@PathParam("iduser") int iduser) throws URISyntaxException {
        return Response.status(200).entity("User with " + iduser + " is deleted successfully").build();
    }
*/
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User Add(@QueryParam("iduser") int iduser,
                    @QueryParam("username") String username,
                    @QueryParam("password") String password,
                    @QueryParam("email") String email,
                    @QueryParam("user_type") byte user_type,
                    @QueryParam("created_date") Timestamp created_date,
                    @QueryParam("activated_date") Timestamp activated_date,
                    @QueryParam("deactivated_date") Timestamp deactivated_date,
                    @QueryParam("confirmation_key") String confirmation_key) {
        User user = new User();
        user.setIduser(iduser);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setUserType(user_type);
        user.setCreatedDate(created_date);
        user.setActivatedDate(activated_date);
        user.setDeactivatedDate(deactivated_date);
        user.setConfirmationKey(confirmation_key);
        return user;
    }

}

