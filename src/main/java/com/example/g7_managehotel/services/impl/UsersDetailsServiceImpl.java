package com.example.g7_managehotel.services.impl;



import com.example.g7_managehotel.controller.Dto.UserRegistrationDto;
import com.example.g7_managehotel.entities.User;
import com.example.g7_managehotel.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UsersDetailsServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UsersDetailsServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("No user found with username : " + username);
        } else {
            return user;
        }
    }

    @Override
    public User save(UserRegistrationDto userRegistrationDto) {


        User user = new User(userRegistrationDto.getUsername(),
                userRegistrationDto.getPassword(),
                userRegistrationDto.getLastname(),userRegistrationDto.getFirstname());

        return userRepository.save(user);
    }
}