package com.example.biblio.controller;

import com.example.biblio.dto.AdherentDetailsDTO;
import com.example.biblio.service.AdherentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adherents")
public class AdherentController {

    @Autowired
    private AdherentService adherentService;

    @GetMapping("/{id}")
    public AdherentDetailsDTO getAdherentDetails(@PathVariable Long id) {
        return adherentService.getAdherentDetails(id);
    }
}
