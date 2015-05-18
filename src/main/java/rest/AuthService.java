package rest;

/**
 * Created by Adnan on 9.5.2015..
 */



        import auth.AuthParameter;
        import auth.AuthResponseObject;
        import auth.ResponseMessages;
        import dbclasses.User;
        import facade.EntityFacade;

        import javax.ejb.Stateless;
        import javax.inject.Inject;
        import javax.ws.rs.*;
        import javax.ws.rs.core.Context;
        import javax.ws.rs.core.MediaType;
        import javax.ws.rs.core.Response;
        import javax.ws.rs.core.UriInfo;

@Path("login")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Stateless
public class AuthService {
    @Context
    private UriInfo uriInfo;
    @Inject
    private EntityFacade entityFacade;


    @POST
    public Response login(AuthParameter authParameter) {
        //ResourceBundle resourceBundle = ResourceBundle.getBundle("NWTBundle");
        AuthResponseObject auth = new AuthResponseObject();



            User user = entityFacade.getUserByUsername(authParameter.getUsername());

            if (user == null ||  !user.getPassword().equals(authParameter.getPassword()))
            {
                return ResponseMessages.INVALID_LOGIN.getResponse();
            }

            return ResponseMessages.INVALID_USERNAME.getResponse();



    }

}