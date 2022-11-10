package com.example.g7_managehotel.entities;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_reservation")
    private Long id;

    @Column(name = "nbre_personne", nullable = false, unique = false)
    private Integer nbre_personne;

    @Column(name = "num_chambre", nullable = false, unique = false)
    private Integer num_chambre;

    @Column(name = "date")
    private Date date;

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
}
