package rest;

import dbclasses.Reservation;
import dbclasses.User;
import services.ReservationService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URISyntaxException;

/**
 * Created by Adnan on 25.3.2015..
 */
@Path("/reservations")
public class ReservationRESTService {

    @GET
    @Path("/getReservation")
    @Produces(MediaType.APPLICATION_JSON)
    public Reservation updateReservationInJSON() {
        ReservationService reservationService = new ReservationService();
        return reservationService.updateReservation(1);
    }

    @POST
    @Path("/createReservation")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createReservationInJSON(Reservation reservation) throws URISyntaxException {
        Reservation reservation1 = new Reservation();
        reservation1.setType(reservation.getType());
        reservation1.setStatus(reservation.getStatus());
        reservation1.setIdreservation(reservation.getIdreservation());
        reservation1.setPrice(reservation.getPrice());
        reservation1.setToDate(reservation.getToDate());
        reservation1.setFromDate(reservation.getFromDate());
        reservation1.setUserIduser(reservation.getUserIduser());
        return Response.status(200).entity("Reservation with ID: " + reservation1.getIdreservation() + " is created successfully").build();
    }

    @DELETE
    @Path("/deleteReservation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUserInJSON(@QueryParam("idreservation") int idreservation) throws URISyntaxException {
        return Response.status(200).entity("Reservation with ID: " + idreservation + " is deleted successfully").build();
    }


}