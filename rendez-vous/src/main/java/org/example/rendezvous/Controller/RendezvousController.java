package org.example.rendezvous.Controller;


import org.example.rendezvous.Entities.Rendezvous;
import org.example.rendezvous.Services.RendezvousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/RENDEZ-VOUS")
public class RendezvousController {

    @Autowired
    private RendezvousService rendezVousService;

    @PostMapping
    public ResponseEntity<Rendezvous> createRendezVous(@RequestBody Rendezvous rendezVous) {
        Rendezvous createdRendezVous = rendezVousService.createRendezVous(rendezVous);
        return ResponseEntity.ok(createdRendezVous);
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
