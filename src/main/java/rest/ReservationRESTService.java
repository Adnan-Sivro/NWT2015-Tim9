package rest;

import dbclasses.Reservation;
import services.ReservationService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Adnan on 25.3.2015..
 */
@Path("/reservations")
public class ReservationRESTService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Reservation updateReservationInJSON() {
        ReservationService reservationService = new ReservationService();
        return reservationService.updateReservation(1);
    }

}