package com.example.g7_managehotel.controller;


import com.example.g7_managehotel.entities.Chambre;
import com.example.g7_managehotel.entities.Reservation;
import com.example.g7_managehotel.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository;


    @GetMapping
    public String listReservation(Model model) {

        model.addAttribute("listReservations", reservationRepository.findAll());

        return "reservations";
    }
    @GetMapping("/new")
    public String newChambre(Model model) {
        Reservation reservation = new Reservation();

        model.addAttribute("reservation", reservation);
        model.addAttribute("listReservations", reservationRepository.findAll());

        return "new_reservations";
    }
}