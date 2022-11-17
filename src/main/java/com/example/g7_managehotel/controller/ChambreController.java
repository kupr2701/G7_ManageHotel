package com.example.g7_managehotel.controller;

import com.example.g7_managehotel.entities.Chambre;
 import com.example.g7_managehotel.repositories.ChambreRepository;
import com.example.g7_managehotel.services.impl.ChambresDetailsServiceImpl;
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

    private final ChambreRepository chambreRepository;

    private final ChambresDetailsServiceImpl chambresDetailsServiceImpl ;

    public ChambreController(ChambreRepository chambreRepository, ChambresDetailsServiceImpl chambresDetailsServiceImpl) {
        this.chambreRepository = chambreRepository;
        this.chambresDetailsServiceImpl = chambresDetailsServiceImpl;
    }

    @GetMapping
    public String listChambre(Model model) {

        model.addAttribute("listChambres", chambreRepository.findAll());

        return "chambres";
    }

    @GetMapping("/new")
    public String newChambre(Model model) {
        Chambre chambre = new Chambre();

        model.addAttribute("chambre", chambre);
        model.addAttribute("listChambres", chambreRepository.findAll());

        return "new_chambres";
    }
    @PostMapping("/saveNew")
    public String saveNewChambre(@ModelAttribute("chambre") @Valid Chambre chambre, Errors errors, Model model)
    {

        if (errors.hasErrors())
        {
            return "new_chambres";
        }

        chambresDetailsServiceImpl.save(chambre);
//        model.addAttribute("listChambres", chambreRepository.findAll());
//        model.addAttribute("listReservation", reservationRepository.findAll());

        return "redirect:/chambres";
    }
}
