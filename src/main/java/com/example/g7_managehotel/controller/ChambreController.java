package com.example.g7_managehotel.controller;

import com.example.g7_managehotel.entities.Chambre;
 import com.example.g7_managehotel.repositories.ChambreRepository;
import com.example.g7_managehotel.repositories.ReservationRepository;
import com.example.g7_managehotel.services.impl.ChambresDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


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
        return "redirect:/chambres";
    }

    @GetMapping("/update")
    public String showUpdateChambreForm(@RequestParam(name="id") long id, Model model)
    {
        Optional<Chambre> optional = chambreRepository.findById(id);
        Chambre chambre = null;
        if (optional.isPresent())
            chambre = optional.get();
        else
            throw new RuntimeException ("chambre not found for id: " + id);

        model.addAttribute("chambre",chambre);
        model.addAttribute("listChambres", chambreRepository.findAll());
        return "update_chambres";
    }

    @GetMapping("/filter")
    public String viewHomePageFilter(Model model, @RequestParam(name="type", defaultValue="") String e)
    {
        model.addAttribute("filter", e);
        model.addAttribute("listChambres", chambreRepository.findByType(e));
        return "chambres";
    }

    @PostMapping("/saveUpdate")
    public String saveUpdateChambre(@ModelAttribute("chambre") @Valid Chambre chambre, Errors errors)
    {
        if (errors.hasErrors())
        {
            return "update_chambres";
        }

        chambreRepository.save(chambre);
        return "redirect:/chambres";
    }

    @GetMapping("/delete")
    public String deleteChambre(@RequestParam(name="id") long id)
    {
            chambreRepository.deleteById(id);
        return "redirect:/chambres";
    }
}
