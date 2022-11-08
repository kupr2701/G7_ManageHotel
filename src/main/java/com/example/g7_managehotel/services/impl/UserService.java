package com.example.g7_managehotel.services.impl;

import com.example.g7_managehotel.controller.Dto.UserRegistrationDto;
import com.example.g7_managehotel.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}