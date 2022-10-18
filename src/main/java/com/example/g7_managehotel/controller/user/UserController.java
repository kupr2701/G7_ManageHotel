package com.example.g7_managehotel.controller.user;


import com.example.g7_managehotel.entities.User;
import com.example.g7_managehotel.services.impl.UsersDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user_form")
public class UserController {

 @Autowired private UsersDetailsServiceImpl userService;
    @Autowired  private UsersDetailsServiceImpl userRepository;

    @GetMapping()
    public String showUserList(Model model) {
        User user = new User();
        model.addAttribute("user" , user);
        return "user_form";

    }
    @PostMapping()
    public String RegisterUserAccount(@ModelAttribute("user") Model model){

        return "redirect:/user_form";
    }




}
