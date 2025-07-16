package com.example.biblio.controller;

import com.example.biblio.dto.LivreAvecExemplairesDTO;
import com.example.biblio.model.Livre;
import com.example.biblio.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/livres")
public class LivreController {

    @Autowired
    private LivreService livreService;

    /**
     * Affiche la liste des livres au format HTML (Thymeleaf)
     */
    @GetMapping
    public String afficherListeLivres(Model model) {
        List<Livre> livres = livreService.findAll();
        model.addAttribute("livres", livres);
        return "adherent/livres";
    }

    /**
     * Récupérer un livre + ses exemplaires format JSON
     */
    @GetMapping("/{id}")
    @ResponseBody
    public LivreAvecExemplairesDTO getLivreAvecSesExemplaires(@PathVariable Long id) {
        return livreService.getLivreAvecExemplaires(id);
    }
}
