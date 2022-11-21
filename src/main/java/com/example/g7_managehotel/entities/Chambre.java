package com.example.g7_managehotel.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "chambres")
public class Chambre{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_chambre")
    private Long id;

    @Column(name = "num_chambre", nullable = false, unique = false)
    private Integer num_chambre;

    @Column(name = "nbre_place", nullable = false, unique = false)
    private Integer nbre_place;

    @Column(name = "etat", length = 50, nullable = false, unique = false)
    private String etat;

    @Column(name = "types",length = 50, nullable = false, unique = false)
    private String type;


//    @NotNull
//    @OneToMany(fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_user", nullable = false)
//    private User user;

    public Chambre() {

    }


    public Chambre(Integer num_chambre, Integer nbre_place, String etat, String type) {
        this.num_chambre = num_chambre;
        this.nbre_place = nbre_place;
        this.etat = etat;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNum_chambre() {
        return num_chambre;
    }

    public void setNum_chambre(Integer num_chambre) {
        this.num_chambre = num_chambre;
    }

    public Integer getNbre_place() {
        return nbre_place;
    }

    public void setNbre_place(Integer nbre_place) {
        this.nbre_place = nbre_place;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}