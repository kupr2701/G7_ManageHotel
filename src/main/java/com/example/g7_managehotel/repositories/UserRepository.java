package com.example.g7_managehotel.repositories;


import com.example.g7_managehotel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
