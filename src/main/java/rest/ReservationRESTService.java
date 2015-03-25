package rest;

import dbclasses.Reservation;
import dbclasses.User;
import services.ReservationService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;

/**
 * Created by Adnan on 25.3.2015..
 */
@Path("/reservations")
public class ReservationRESTService {
    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Reservation updateReservationInJSON() {
        ReservationService reservationService = new ReservationService();
        return reservationService.updateReservation(1);
    }*/

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Reservation createReservation(@QueryParam("idreservation") int idreservation,
                    @QueryParam("from_date") Timestamp from_date,
                    @QueryParam("to_date") Timestamp to_date,
                    @QueryParam("price") float price,
                    @QueryParam("status") byte status,
                    @QueryParam("type") Byte type) {
        Reservation reservation = new Reservation();
        reservation.setIdreservation(idreservation);
        reservation.setFromDate(from_date);
        reservation.setToDate(to_date);
        reservation.setPrice(price);
        reservation.setStatus(status);
        reservation.setType(type);
        return reservation;
    }

}