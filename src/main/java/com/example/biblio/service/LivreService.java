package com.example.biblio.service;

import com.example.biblio.dto.ExemplaireSimpleDTO;
import com.example.biblio.dto.LivreAvecExemplairesDTO;
import com.example.biblio.model.Livre;
import com.example.biblio.repository.LivreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivreService {
    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public List<Livre> findAll() {
        return livreRepository.findAll();
    }

    public Livre findById(Long id) {
        return livreRepository.findById(id).orElse(null);
    }

    public LivreAvecExemplairesDTO getLivreAvecExemplaires(Long id) {
        Livre livre = livreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livre non trouvé"));

        List<ExemplaireSimpleDTO> exemplaires = livre.getExemplaires()
                .stream()
                .map(e -> new ExemplaireSimpleDTO(e.getId(), e.isDisponible(), e.getNomExemplaire()))
                .collect(Collectors.toList());

        return new LivreAvecExemplairesDTO(
                livre.getId(),
                livre.getTitre(),
                livre.getAuteur(),
                livre.isRestreint(),
                exemplaires
        );
    }

    public Livre save(Livre livre) {
        return livreRepository.save(livre);
    }

    public void delete(Long id) {
        livreRepository.deleteById(id);
    }
}
