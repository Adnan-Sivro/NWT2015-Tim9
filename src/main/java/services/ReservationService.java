package services;

import dbclasses.Reservation;

/**
 * Created by Adnan on 25.3.2015..
 */
public class ReservationService {

    public Reservation updateReservation(int idreservation) {
        Reservation reservation = new Reservation();
        try {

            reservation.setIdreservation(idreservation);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        return reservation;

    }
}
