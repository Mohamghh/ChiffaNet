package org.example.medecin_disponibilite.Services;

import org.example.medecin_disponibilite.Entities.Praticien;
import org.example.medecin_disponibilite.Repositories.PraticienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PraticienServiceImpl implements PraticienService {

    @Autowired
    private PraticienRepo praticienRepo;

    @Override
    public List<Praticien> getAllPraticiens() {
        return praticienRepo.findAll();
    }

    @Override
    public Optional<Praticien> getPraticienById(Long id) {
        return praticienRepo.findById(id);
    }

    @Override
    public Praticien createPraticien(Praticien praticien) {
        return praticienRepo.save(praticien);
    }

    @Override
    public Praticien updatePraticien(Long id, Praticien praticienDetails) {
        Praticien praticien = praticienRepo.findById(id).orElseThrow();
        praticien.setNom(praticienDetails.getNom());
        praticien.setPrenom(praticienDetails.getPrenom());
        praticien.setSpecialite(praticienDetails.getSpecialite());
        praticien.setDisponibilites(praticienDetails.getDisponibilites());
        return praticienRepo.save(praticien);
    }
}
