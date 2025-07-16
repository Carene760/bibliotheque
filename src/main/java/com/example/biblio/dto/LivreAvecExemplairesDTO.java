// LivreAvecExemplairesDTO.java
package com.example.biblio.dto;

import java.util.List;

public class LivreAvecExemplairesDTO {
    private Long id;
    private String titre;
    private String auteur;
    private boolean restreint;
    private List<ExemplaireSimpleDTO> exemplaires;

    public LivreAvecExemplairesDTO(Long id, String titre, String auteur, boolean restreint, List<ExemplaireSimpleDTO> exemplaires) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.restreint = restreint;
        this.exemplaires = exemplaires;
    }

    public Long getId() { return id; }
    public String getTitre() { return titre; }
    public String getAuteur() { return auteur; }
    public boolean isRestreint() { return restreint; }
    public List<ExemplaireSimpleDTO> getExemplaires() { return exemplaires; }
}
