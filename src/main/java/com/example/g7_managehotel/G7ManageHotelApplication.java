package com.example.g7_managehotel;

import com.example.g7_managehotel.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@SpringBootApplication
public class G7ManageHotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(G7ManageHotelApplication.class, args);
    }

    @GetMapping("/test")
    public List<User> hello(){
        return List.of(new User ("joel", "genteeeeuu","kuifo", "yimga"));
    }
}
