package com.example.g7_managehotel.entities;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "reservations")
public class Reservation implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    private Long id;

    @Column(name = "num_chambre")
    private Integer num_chambre;

    @Column(name = "nbre_personne")
    private Integer nbre_personne;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private Date date;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ch_id")
    private Chambre chambre;
    public Reservation(Integer nbre_personne, Integer num_chambre, Date date) {
        this.nbre_personne = nbre_personne;
        this.num_chambre = num_chambre;
        this.date = date;
    }

    public Reservation() {

    }

    public Integer getNbre_personne() {
        return nbre_personne;
    }

    public void setNbre_personne(Integer nbre_personne) {
        this.nbre_personne = nbre_personne;
    }

    public Integer getNum_chambre() {
        return num_chambre;
    }

    public void setNum_chambre(Integer num_chambre) {
        this.num_chambre = num_chambre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }
}
