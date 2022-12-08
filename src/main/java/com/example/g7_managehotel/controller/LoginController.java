package com.example.g7_managehotel.controller;


import com.example.g7_managehotel.controller.Dto.LoginSignDto;
import com.example.g7_managehotel.controller.Dto.UserRegistrationDto;
import com.example.g7_managehotel.entities.Chambre;
import com.example.g7_managehotel.entities.User;
import com.example.g7_managehotel.repositories.UserRepository;
import com.example.g7_managehotel.services.impl.UsersDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsersDetailsServiceImpl userService;
    @Autowired  private UserRepository userRepository;

    @GetMapping("/res")
    public String LoginForm( @RequestParam(name="motCle", defaultValue="") String d , Model model)
    {
        model.addAttribute("res", d);

        User userObj = (User) userService.loadUserByUsername(d);
        if ( userObj == null )
               return  "result";
        return "redirect:/reservations";
    }

    @GetMapping()
    public String login() {

        return "login";
    }
}
