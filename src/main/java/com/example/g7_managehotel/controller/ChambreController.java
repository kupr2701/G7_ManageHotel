package com.example.g7_managehotel.controller;

import com.example.g7_managehotel.entities.Chambre;
import com.example.g7_managehotel.repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/chambres")
public class ChambreController {

    @Autowired
    private ChambreRepository chambreRepository;


    @GetMapping
    public String listChambre(Model model) {

        model.addAttribute("listChambres", chambreRepository.findAll());

        return "/chambres";
    }

    @GetMapping("/new")
    public String newChambre(Model model) {

          model.addAttribute("chambre", new Chambre());

        return "/chambres";
    }
    @PostMapping("/saveNew")
    public String saveNewChambre(@ModelAttribute("chambre") @Valid Chambre chambre, Errors errors, Model model)
    {

//        if (errors.hasErrors())
//        {
//            model.addAttribute("listReservation", reservationRepository.findAll());
//            return "new_chambres";
//        }

          chambreRepository.save(chambre);
          model.addAttribute("listChambres", chambreRepository.findAll());
//        model.addAttribute("listReservation", reservationRepository.findAll());

        return "redirect:/chambres";
    }
}
