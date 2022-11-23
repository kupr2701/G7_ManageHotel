package com.example.g7_managehotel.services.impl;


import com.example.g7_managehotel.entities.Reservation;
import com.example.g7_managehotel.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class reservationDetailsServiceImpl {

    private static  ReservationRepository reservationRepository;

    @Autowired
    public reservationDetailsServiceImpl(ReservationRepository reservationRepository) {
        super();
        this.reservationRepository = reservationRepository;
    }
    public static Reservation save(Reservation resev) {

        Reservation reservation = new Reservation (resev.getNbre_personne(),  resev.getDate(), resev.getChambre());

        return reservationRepository.save(reservation);
    }
}
