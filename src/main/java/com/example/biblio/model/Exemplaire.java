package com.example.biblio.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "exemplaire")
public class Exemplaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exemplaire")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_livre", nullable = false)
    private Livre livre;

    @Column(nullable = false)
    private boolean disponible = true;

    @Column(nullable = false)
    private String nom_exemplaire;

    @OneToMany(mappedBy = "exemplaire", cascade = CascadeType.ALL)
    private Set<Pret> prets = new HashSet<>();

    @OneToMany(mappedBy = "exemplaire", cascade = CascadeType.ALL)
    private Set<Reservation> reservations = new HashSet<>();

    // Constructeurs
    public Exemplaire() {
    }

    public Exemplaire(Livre livre, boolean disponible, String nom_exemplaire) {
        this.livre = livre;
        this.disponible = disponible;
        this.nom_exemplaire = nom_exemplaire;
    }

    public Exemplaire(Livre livre) {
        this.livre = livre;
        this.disponible = true; // ou false par défaut
    }


    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomExemplaire()
    {
        return nom_exemplaire;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Set<Pret> getPrets() {
        return prets;
    }

    public void setPrets(Set<Pret> prets) {
        this.prets = prets;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }
}