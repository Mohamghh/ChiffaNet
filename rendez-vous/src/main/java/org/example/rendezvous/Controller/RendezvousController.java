package org.example.rendezvous.Controller;


import org.example.rendezvous.DisponibiliteFeignClient;
import org.example.rendezvous.Entities.DisponibiliteDTO;
import org.example.rendezvous.Entities.Rendezvous;
import org.example.rendezvous.Services.RendezvousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/RENDEZ-VOUS")
public class RendezvousController {

    @Autowired
    private DisponibiliteFeignClient disponibiliteFeignClient;

    @Autowired
    private RendezvousService rendezVousService;

    @PostMapping
    public ResponseEntity<Rendezvous> createRendezVous(@RequestBody Rendezvous rendezVous) {
        List<DisponibiliteDTO> disponibilites = disponibiliteFeignClient.getDisponibilitesByPraticienId(rendezVous.getPraticienId());


        // Vérifier si le praticien a des disponibilités à la date et heure demandées
        boolean isAvailable = checkDisponibilite(disponibilites, rendezVous.getDate(), rendezVous.getHeure());

        if (!isAvailable) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);  // Ou toute autre logique si le praticien n'est pas disponible
        }

        Rendezvous createdRendezVous = rendezVousService.createRendezVous(rendezVous);
        return ResponseEntity.ok(createdRendezVous);


    }

    private boolean checkDisponibilite(List<DisponibiliteDTO> disponibilites, LocalDate date, LocalTime heure) {
        // Logique pour vérifier si le praticien est disponible à la date et à l'heure demandées
        for (DisponibiliteDTO dispo : disponibilites) {
            // Vérification si la date et l'heure du rendez-vous se trouvent dans les disponibilités du praticien
            if (dispo.getDate().equals(date) && dispo.getHeureDebut().isBefore(heure) && dispo.getHeureFin().isAfter(heure)) {
                return true;  // Le praticien est disponible à cette date et heure
            }
        }
        return false;  // Le praticien n'est pas disponible
    }



    @PutMapping("/{id}")
    public ResponseEntity<Rendezvous> updateRendezVous(@PathVariable Long id, @RequestBody Rendezvous updatedRendezVous) {
        Rendezvous updated = rendezVousService.updateRendezVous(id, updatedRendezVous);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRendezVous(@PathVariable Long id) {
        rendezVousService.deleteRendezVous(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rendezvous> getRendezVousById(@PathVariable Long id) {
        Optional<Rendezvous> rendezVous = rendezVousService.getRendezVousById(id);
        return rendezVous.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Rendezvous> getAllRendezVous() {
        return rendezVousService.getAllRendezVous();
    }
}
