package com.example.g7_managehotel.services.impl;

import com.example.g7_managehotel.entities.Chambre;
import com.example.g7_managehotel.repositories.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChambresDetailsServiceImpl  {


    private final ChambreRepository chambreRepository;

    @Autowired
    public ChambresDetailsServiceImpl(ChambreRepository chambreRepository) {
        super();
        this.chambreRepository = chambreRepository;
    }

    public Chambre save(Chambre chambres) {


        Chambre  chambre = new Chambre(chambres.getNum_chambre(), chambres.getNbre_place(), chambres.getEtat(),
                chambres.getType());

        return chambreRepository.save(chambre);
    }
}
