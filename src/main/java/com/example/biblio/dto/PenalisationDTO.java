// PenalisationDTO.java
package com.example.biblio.dto;

import java.time.LocalDate;

public class PenalisationDTO {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String etat;

    public PenalisationDTO(Long id, LocalDate dateDebut, LocalDate dateFin, String etat) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.etat = etat;
    }

    // Getters et setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDateDebut() { return dateDebut; }
    public void setDateDebut(LocalDate dateDebut) { this.dateDebut = dateDebut; }
    public LocalDate getDateFin() { return dateFin; }
    public void setDateFin(LocalDate dateFin) { this.dateFin = dateFin; }
    public String getEtat() { return etat; }
    public void setEtat(String etat) { this.etat = etat; }
}
