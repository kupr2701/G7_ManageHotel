package com.example.g7_managehotel;


import com.example.g7_managehotel.entities.User;
import com.example.g7_managehotel.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;




@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;

    @Test
    public void testaddnew(){

        User user = new User();
        user.setUsername("joel");
        user.setPassword("kypj2701");
        user.setFirstname("fred");
        user.setLastname("robert");
        
        User savedUser = repo.save(user);

    }
}
