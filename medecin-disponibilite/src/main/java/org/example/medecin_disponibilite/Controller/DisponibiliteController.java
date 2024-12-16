package org.example.medecin_disponibilite.Controller;


import org.example.medecin_disponibilite.Entities.Disponibilite;
import org.example.medecin_disponibilite.Services.DisponibiliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/disponibilites")
public class DisponibiliteController {

    @Autowired
    private DisponibiliteService disponibiliteService;

    @GetMapping
    public List<Disponibilite> getAllDisponibilites() {
        return disponibiliteService.getAllDisponibilites();
    }

    @GetMapping("/{id}")
    public Optional<Disponibilite> getDisponibiliteById(@PathVariable Long id) {
        return disponibiliteService.getDisponibiliteById(id);
    }

    @PostMapping
    public Disponibilite createDisponibilite(@RequestBody Disponibilite disponibilite) {
        return disponibiliteService.createDisponibilite(disponibilite);
    }

    @PutMapping("/{id}")
    public Disponibilite updateDisponibilite(@PathVariable Long id, @RequestBody Disponibilite disponibiliteDetails) {
        return disponibiliteService.updateDisponibilite(id, disponibiliteDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteDisponibilite(@PathVariable Long id) {
        disponibiliteService.deleteDisponibilite(id);
    }

    @GetMapping("/praticien/{praticienId}")
    public List<Disponibilite> getDisponibilitesByPraticienId(@PathVariable Long praticienId) {
        return disponibiliteService.getDisponibilitesByPraticienId(praticienId);
    }

}
