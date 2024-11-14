package org.example.medecin_disponibilite.Controller;

import org.example.medecin_disponibilite.Entities.Specialite;
import org.example.medecin_disponibilite.Services.SpecialiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/specialites")
public class SpecialiteController {

    @Autowired
    private SpecialiteService specialiteService;

    @GetMapping
    public List<Specialite> getAllSpecialites() {
        return specialiteService.getAllSpecialites();
    }

    @GetMapping("/{id}")
    public Optional<Specialite> getSpecialiteById(@PathVariable Long id) {
        return specialiteService.getSpecialiteById(id);
    }

    @PostMapping
    public Specialite createSpecialite(@RequestBody Specialite specialite) {
        return specialiteService.createSpecialite(specialite);
    }


}
