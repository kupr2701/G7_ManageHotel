package com.example.g7_managehotel.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chambres")
public class ChambreController {

    @GetMapping
    public String chambre() {
        return "/chambres";
    }
}
