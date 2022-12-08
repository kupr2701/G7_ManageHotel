package com.example.g7_managehotel.entities;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    private Long id;

    @Column(name = "nbre_personne")
    private Integer nbre_personne;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date")
    private Date date;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "ch_id")
    private Chambre chambre;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "us_id", nullable = false)
    private User user;


    public Reservation(Integer nbre_personne, Date date, Chambre chambre) {
        this.nbre_personne = nbre_personne;
        this.date = date;
        this.chambre =  chambre;
    }

    public Reservation() {

    }

    public Integer getNbre_personne() {
        return nbre_personne;
    }

    public void setNbre_personne(Integer nbre_personne) {
        this.nbre_personne = nbre_personne;
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
