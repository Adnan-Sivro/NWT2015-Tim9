package rest;

import dbclasses.Keycard;
import dbclasses.User;
import services.KeycardService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

/**
 * Created by Enes on 31.3.2015..
 */
@Path("/keycards")
public class KeycardRESTService {

    @GET
    @Path("/getKeycard")
    @Produces(MediaType.APPLICATION_JSON)
    public Keycard updateKeycardInJSON() {
        KeycardService cardService = new KeycardService();
        return cardService.updateKeycard(1);
    }

    @POST
    @Path("/createKeycard")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createKeycardInJSON(Keycard card) throws URISyntaxException {
        Keycard newCard = new Keycard();

        newCard.setIdkeycard(card.getIdkeycard());
        newCard.setAccessIdentifier(card.getAccessIdentifier());
        newCard.setNumber(card.getNumber());
        return Response.status(200).entity("Keycard with ID: " + newCard.getIdkeycard() + " is created successfully").build();
    }

    @DELETE
    @Path("/deleteKeycard")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteKeycardInJSON(@QueryParam("idkeycard") int idcard) throws URISyntaxException {
        return Response.status(200).entity("Keycard with ID: " + idcard + " is deleted successfully").build();
    }
}
