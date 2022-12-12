package com.example.g7_managehotel.controller;


import com.example.g7_managehotel.entities.Reservation;
import com.example.g7_managehotel.repositories.ChambreRepository;
import com.example.g7_managehotel.repositories.ReservationRepository;
import com.example.g7_managehotel.repositories.UserRepository;
import com.example.g7_managehotel.services.impl.reservationDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired  private UserRepository userRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    private final ChambreRepository chambreRepository;

    public ReservationController(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    @GetMapping
    public String listReservation(Model model) {

        model.addAttribute("listReservations", reservationRepository.findAll());

        return "reservations";
    }
    @GetMapping("/new")
    public String newReservation(Model model) {
        Reservation reservation = new Reservation();

        model.addAttribute("reservation", reservation);
        model.addAttribute("listChambres", chambreRepository.findAll());
        model.addAttribute("listUsers", userRepository.findAll());

        return "new_reservations";
    }
    @PostMapping("/saveNew")
    public String saveNewReservation(@ModelAttribute("reservation") @Valid Reservation reservation, Errors errors, Model model)
    {

        if (errors.hasErrors())
        {
            model.addAttribute("listChambres", chambreRepository.findAll());
            model.addAttribute("listUsers", userRepository.findAll());
            return "new_reservations";
        }

        reservationDetailsServiceImpl.save(reservation);

        return "redirect:/reservations";
    }
    @GetMapping("/View")
    public String viewHomePage(Model model, @RequestParam(name="user", defaultValue="") String d)
    {
        long num = Long.parseLong(d);
        if (num == 0)
            model.addAttribute("listReservations", reservationRepository.findAll());
        else
            model.addAttribute("listReservations", reservationRepository.chercherReservationParNumUser(num));

        model.addAttribute("View", d);
        model.addAttribute("listUsers", userRepository.findAll());
        return "reservations";
    }


    @GetMapping("/update")
    public String showUpdateReservationForm(@RequestParam(name="id") long id, Model model)
    {
        Optional<Reservation> optional = reservationRepository.findById(id);
        Reservation reservation= null;
        if (optional.isPresent())
           reservation = optional.get();
        else
            throw new RuntimeException ("reservation not found for id: " + id);

        model.addAttribute("reservation",reservation);
        model.addAttribute("listChambres", chambreRepository.findAll());
        model.addAttribute("listUsers", userRepository.findAll());

        return "update_reservations";
    }
    @PostMapping("/saveUpdate")
    public String saveUpdateReservation(@ModelAttribute("reservation") @Valid Reservation reservation, Errors errors)
    {
        if (errors.hasErrors())
        {
            return "update_reservations";
        }

        reservationRepository.save(reservation);
        return "redirect:/reservations";
    }
    @GetMapping("/reservations/filter1")
    public String viewPageFilter1(Model model, @RequestParam(name="user", defaultValue="") String d)
    {
        long num = Long.parseLong(d);
        if (num == 0)
            model.addAttribute("listReservations", reservationRepository.findAll());
        else
            model.addAttribute("listReservations", reservationRepository.chercherReservationParNumUser(num));

        model.addAttribute("filter1", d);
        model.addAttribute("listUsers", userRepository.findAll());
        return "reservations";
    }
    @GetMapping("/delete")
    public String deleteReservation(@RequestParam(name="id") long id)
    {

        reservationRepository.deleteById(id);
        return "redirect:/reservations";
    }
}
