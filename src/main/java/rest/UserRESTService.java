package rest;

import dbclasses.User;
import services.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.swing.text.html.HTML;
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

    @GET
    @Path("/getUser")
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUserInJSON() {
        UserService userService = new UserService();
        return userService.updateUser(1);
    }

    @POST
    @Path("/createUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUserInJSON(User user) throws URISyntaxException{
        User user1 = new User();
        user1.setUsername(user.getUsername());
        user1.setUserType(user.getUserType());
        user1.setEmail(user.getEmail());
        user1.setConfirmationKey(user.getConfirmationKey());
        user1.setDeactivatedDate(user.getDeactivatedDate());
        user1.setActivatedDate(user.getActivatedDate());
        user1.setPassword(user.getPassword());
        user1.setCreatedDate(user.getCreatedDate());
        user1.setIduser(user.getIduser());

        return Response.status(200).entity("User with ID: " + user1.getIduser() + " is created successfully").build();
    }

    @DELETE
    @Path("/deleteUser")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUserInJSON(@QueryParam("iduser") int iduser) throws URISyntaxException {
        return Response.status(200).entity("User with ID: " + iduser + " is deleted successfully").build();
    }


}

