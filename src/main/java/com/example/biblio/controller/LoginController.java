package com.example.biblio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.example.biblio.dto.LivreAvecExemplairesDTO;
import com.example.biblio.model.Livre;
import com.example.biblio.service.LivreService;

@Controller
public class LoginController {

     @Autowired
    private LivreService livreService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model) {
        List<Livre> livres = livreService.findAll();
        model.addAttribute("livres", livres);
        return "admin/dashboard"; // retournera la vue admin/dashboard.html
    }

    @GetMapping("/adherent/accueil")
    public String adherentAccueil(Model model) {
        List<Livre> livres = livreService.findAll();
        model.addAttribute("livres", livres);
        return "adherent/accueil"; // retournera la vue adherent/accueil.html
    }
}