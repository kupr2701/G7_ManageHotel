package com.example.g7_managehotel.repositories;

import com.example.g7_managehotel.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {


}
