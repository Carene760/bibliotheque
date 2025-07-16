// AbonnementDTO.java
package com.example.biblio.dto;

import java.time.LocalDate;

public class AbonnementDTO {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private boolean actif;

    public AbonnementDTO(Long id, LocalDate dateDebut, LocalDate dateFin, boolean actif) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.actif = actif;
    }

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }
    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }
    public boolean isActif() { return actif; }
    public void setActif(boolean actif) { this.actif = actif; }
}
