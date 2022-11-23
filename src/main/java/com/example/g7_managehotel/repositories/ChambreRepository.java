package com.example.g7_managehotel.repositories;

import com.example.g7_managehotel.entities.Chambre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    List<Chambre> findByEtat(String e);


}
