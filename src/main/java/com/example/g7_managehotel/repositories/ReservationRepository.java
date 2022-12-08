package com.example.g7_managehotel.repositories;

import com.example.g7_managehotel.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("select r from Reservation r where r.user.id = ?1")
    List<Reservation> chercherReservationParNumUser(long num);


}
