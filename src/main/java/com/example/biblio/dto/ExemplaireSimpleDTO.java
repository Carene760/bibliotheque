// ExemplaireSimpleDTO.java
package com.example.biblio.dto;

public class ExemplaireSimpleDTO {
    private Long id;
    private boolean disponible;
    private String nom_exemplaire;

    public ExemplaireSimpleDTO(Long id, boolean disponible, String nom_exemplaire) {
        this.id = id;
        this.disponible = disponible;
        this.nom_exemplaire = nom_exemplaire;
    }

    public Long getId() { return id; }
    public boolean isDisponible() { return disponible; }
    public String getNomExemplaire() { return nom_exemplaire; }
}
