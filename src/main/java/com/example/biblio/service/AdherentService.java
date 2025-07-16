package com.example.biblio.service;

import com.example.biblio.dto.AbonnementDTO;
import com.example.biblio.dto.AdherentDetailsDTO;
import com.example.biblio.dto.PenalisationDTO;
import com.example.biblio.model.Abonnement;
import com.example.biblio.model.Adherent;
import com.example.biblio.model.Penalisation;
import com.example.biblio.repository.AbonnementRepository;
import com.example.biblio.repository.AdherentRepository;
import com.example.biblio.repository.PenalisationRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdherentService implements UserDetailsService {

    private final AdherentRepository adherentRepository;
    private final AbonnementRepository abonnementRepository;
    private final PenalisationRepository penalisationRepository;

    public AdherentService(AdherentRepository adherentRepository,
                          AbonnementRepository abonnementRepository,
                          PenalisationRepository penalisationRepository) {
        this.adherentRepository = adherentRepository;
        this.abonnementRepository = abonnementRepository;
        this.penalisationRepository = penalisationRepository;
    }

    public AdherentDetailsDTO getAdherentDetails(Long adherentId) {
        Adherent adherent = adherentRepository.findById(adherentId)
                .orElseThrow(() -> new RuntimeException("Adherent non trouvé"));

        // Récupérer les abonnements liés à l'adhérent
        List<Abonnement> abonnements = abonnementRepository.findByAdherentId(adherentId);

        // Récupérer les pénalisations en cours de l'adhérent
        List<Penalisation> penalisationActives = penalisationRepository.findByAdherentId(adherentId)
                .stream()
                .filter(p -> Penalisation.Etat.EN_COURS.equals(p.getEtat()))
                .collect(Collectors.toList());

        // Transformation en DTO
        List<AbonnementDTO> abonnementsDTO = abonnements.stream()
                .map(a -> new AbonnementDTO(a.getId(), a.getDateDebut(), a.getDateFin(), a.isActif()))
                .collect(Collectors.toList());

        List<PenalisationDTO> penalisationDTO = penalisationActives.stream()
                .map(p -> new PenalisationDTO(
                        p.getId(),
                        p.getDateDebut(),
                        p.getDateFin(),
                        p.getEtat().name()  // conversion enum -> String
                ))
                .collect(Collectors.toList());

        // Calcul du quota restant (exemple, adapte selon ta logique métier)
        int quotaTotal = adherent.getProfil().getQuota();
        int quotaRestant = quotaTotal - abonnements.size();

        // Construction du DTO final
        AdherentDetailsDTO dto = new AdherentDetailsDTO();
        dto.setId(adherent.getId());
        dto.setNom(adherent.getNom());
        dto.setPrenom(adherent.getPrenom());
        dto.setEmail(adherent.getEmail());
        dto.setTelephone(adherent.getTelephone());
        dto.setDateNaissance(adherent.getDateNaissance());
        dto.setAdresse(adherent.getAdresse());
        dto.setActif(adherent.isActif());
        dto.setDateInscription(adherent.getDateInscription());
        dto.setAbonnements(abonnementsDTO);
        dto.setPenalisationActives(penalisationDTO);
        dto.setQuotaRestant(quotaRestant);

        return dto;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return adherentRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Adherent not found with email: " + email));
    }

    public Adherent findByEmail(String email) {
        return adherentRepository.findAdByEmail(email);
    }
    
}
