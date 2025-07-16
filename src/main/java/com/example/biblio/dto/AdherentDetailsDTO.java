// AdherentDetailsDTO.java
package com.example.biblio.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class AdherentDetailsDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private LocalDate dateNaissance;
    private String adresse;
    private boolean actif;
    private LocalDateTime dateInscription;
    private List<AbonnementDTO> abonnements;
    private List<PenalisationDTO> penalisationActives;
    private int quotaRestant;

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public LocalDate getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public boolean isActif() { return actif; }
    public void setActif(boolean actif) { this.actif = actif; }

    public LocalDateTime getDateInscription() { return dateInscription; }
    public void setDateInscription(LocalDateTime dateInscription) { this.dateInscription = dateInscription; }

    public List<AbonnementDTO> getAbonnements() { return abonnements; }
    public void setAbonnements(List<AbonnementDTO> abonnements) { this.abonnements = abonnements; }

    public List<PenalisationDTO> getPenalisationActives() { return penalisationActives; }
    public void setPenalisationActives(List<PenalisationDTO> penalisationActives) { this.penalisationActives = penalisationActives; }

    public int getQuotaRestant() { return quotaRestant; }
    public void setQuotaRestant(int quotaRestant) { this.quotaRestant = quotaRestant; }
}
