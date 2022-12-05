package com.example.g7_managehotel.controller;


import com.example.g7_managehotel.controller.Dto.LoginSignDto;
import com.example.g7_managehotel.entities.User;
import com.example.g7_managehotel.repositories.UserRepository;
import com.example.g7_managehotel.services.impl.UsersDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsersDetailsServiceImpl userService;
    @Autowired  private UserRepository userRepository;

    @GetMapping("")
    public String LoginForm(@RequestParam(name="id") long id)
    {
        Optional<User> optional = userRepository.findById(id);
        LoginSignDto loginSignDto = null;
        if (optional.isPresent())
            loginSignDto = optional.get();
        else
            throw new RuntimeException ("user not found for id: " + id);


        return "chambres";
    }

    @PostMapping("/login")
    public String login() {

        return "redirect:/chambres";
    }
}
