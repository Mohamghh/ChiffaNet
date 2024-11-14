package org.example.medecin_disponibilite.Controller;

import org.example.medecin_disponibilite.Entities.Praticien;
import org.example.medecin_disponibilite.Services.PraticienService;
import org.example.medecin_disponibilite.config.MedecinDispoConfigParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RefreshScope
@RequestMapping("/api/praticiens")
public class PraticienController {

    @Autowired
    private PraticienService praticienService;


    @Value("${global.params.p1}")
    private String p1;
    @Value("${global.params.p2}")
    private String p2;

    @Autowired
    private MedecinDispoConfigParams medecinDispoConfigParams;


    @GetMapping("/medecinTest")
    public Map<String,String> configTest(){
        return Map.of("p1",p1,"p2",p2);
    }

    @GetMapping("/medecinTest2")
    public MedecinDispoConfigParams configTest2(){
        return medecinDispoConfigParams;
    }

    @GetMapping
    public List<Praticien> getAllPraticiens() {
        return praticienService.getAllPraticiens();
    }

    @GetMapping("/{id}")
    public Optional<Praticien> getPraticienById(@PathVariable Long id) {
        return praticienService.getPraticienById(id);
    }

    @PostMapping
    public Praticien createPraticien(@RequestBody Praticien praticien) {
        return praticienService.createPraticien(praticien);
    }

    @PutMapping("/{id}")
    public Praticien updatePraticien(@PathVariable Long id, @RequestBody Praticien praticienDetails) {
        return praticienService.updatePraticien(id, praticienDetails);
    }
}
