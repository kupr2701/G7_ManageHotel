package com.example.g7_managehotel.controller;



import com.example.g7_managehotel.entities.Reservation;
import com.example.g7_managehotel.entities.User;
import com.example.g7_managehotel.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
@RequestMapping()
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/login")
    public String login() {


        return "login";
    }
    @GetMapping("/logout")
    public String logout() {


        return "index";
    }
}
