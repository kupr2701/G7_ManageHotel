package com.example.g7_managehotel.controller;


import com.example.g7_managehotel.controller.Dto.UserRegistrationDto;
import com.example.g7_managehotel.entities.Chambre;
import com.example.g7_managehotel.entities.Reservation;
import com.example.g7_managehotel.entities.User;
import com.example.g7_managehotel.repositories.ReservationRepository;
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
@RequestMapping("/users")
public class UserController {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired private UsersDetailsServiceImpl userService;
    @Autowired  private UserRepository userRepository;

    @GetMapping()
    public String showUserList(Model model) {
        model.addAttribute("listUsers", userRepository.findAll());
        return "users";
    }

    @GetMapping("/New")
    public String showForm(Model model) {
        User user = new User();
        model.addAttribute("user" , user);
        model.addAttribute("listUsers", userRepository.findAll());

        return "user_form";
    }

    @PostMapping("/saveNew")
    public String RegisterUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userRegistrationDto , Errors errors) {
        if (errors.hasErrors()) {

            return "user_form";
        }

        userService.save(userRegistrationDto);
        return "result";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(name="id") long id)
    {
        List<Reservation> myList = reservationRepository.chercherReservationParNumUser(id);
        if (myList.isEmpty())
              userRepository.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String showUpdateUserForm(@RequestParam(name="id") long id, Model model)
    {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if (optional.isPresent())
            user = optional.get();
        else
            throw new RuntimeException ("user not found for id: " + id);

        model.addAttribute("user",user);
        model.addAttribute("listUsers", userRepository.findAll());
        return "update_users";
    }
    @PostMapping("/saveUpdate")
    public String saveUpdateUser(@ModelAttribute("user") @Valid UserRegistrationDto user, Errors errors)
    {
        if (errors.hasErrors())
        {
            return "update_users";
        }
        userService.save(user);
        return "redirect:/users";
    }

}
