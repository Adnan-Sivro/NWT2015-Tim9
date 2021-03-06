package auth;

/**
 * Created by Adnan on 9.5.2015..
 */
import auth.entities.AuthParameterRegister;
import dbclasses.User;
import facade.EntityFacade;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("user")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Stateless
public class RegistrationService {
    @Context
    private UriInfo uriInfo;
    @Inject
    private EntityFacade entityFacade;


    @POST
    @Path("/register")
    public Response createUser(AuthParameterRegister aUser) {

        try{
            if (aUser == null)
                throw new BadRequestException();

            User user = new User();
            user.setUsername(aUser.getUsername());
            user.setPassword(aUser.getPassword());
            user.setEmail(aUser.getEmail());

            user = entityFacade.createUser(user);

            /*VerificationToken token = VerificationToken.generateToken();
            token.setActionType(ActionTypeEnum.ACTIVATION);
            token.setTokenStatus(TokenStatusEnum.ACTIVE);
            token.setUser(user);
            entityFacade.createToken(token);


            boolean sent = Mailer.sendActivationMail(user.getEmail(), token.getId());
            if (!sent)
                throw new WebApplicationException();
*/
            return Response.status(201).build();
        }catch (Exception e)
        {
            Object message=new Object(){
                public String messageCode= "awdawd";
            };
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

    }

/*
    @GET
    @Path("/activate/{token}")
    public Response activate(@PathParam("token") String hash) {

        VerificationToken token = entityFacade.getToken(hash);
        if (!isActivationTokenValid(token))
            throw new BadRequestException();

        //activate user
        User user = token.getUser();
        user.setActive(true);
        entityFacade.updateUser(user);

        //disable token
        token.setTokenStatus(TokenStatusEnum.USED);
        entityFacade.updateToken(token);
        return Response.temporaryRedirect(URI.create("/")).build();
    }
*/
  /*
    @PUT
    @Path("/reset")
    public Response reset(String jsonString) {
        try{
            JsonParser parser = new JsonParser();
            JsonObject jobj = (JsonObject) parser.parse(jsonString);

            String username = jobj.get("username").getAsString();

            User user = entityFacade.getUserByUsername(username);
            VerificationToken token = VerificationToken.generateToken();
            token.setActionType(ActionTypeEnum.PASSWORD_RECOVERY);
            token.setTokenStatus(TokenStatusEnum.ACTIVE);
            token.setUser(user);
            entityFacade.createToken(token);


            boolean sent = Mailer.sendRecoveryMail("jasmin.kaldzija@gmail.com", token.getId());
            if (!sent)
                throw new WebApplicationException();

            return Response.ok().build();
        }catch (Exception e)
        {
            return ResponseMessages.INVALID_USERNAME.getResponse();
        }
    }

    private boolean isActivationTokenValid(VerificationToken token) {
        boolean activation = token.getActionType() == ActionTypeEnum.ACTIVATION;
        boolean unused = token.getTokenStatus() == TokenStatusEnum.ACTIVE;

        return activation && unused;
    }
*/
}