package org.example.medecin_disponibilite.Services;

import org.example.medecin_disponibilite.Entities.Disponibilite;
import org.example.medecin_disponibilite.Repositories.DisponibiliteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class DisponibiliteServiceImpl implements DisponibiliteService {
    @Autowired
    private DisponibiliteRepo disponibiliteRepo;

    @Override
    public List<Disponibilite> getAllDisponibilites() {
        return disponibiliteRepo.findAll();
    }

    @Override
    public Optional<Disponibilite> getDisponibiliteById(Long id) {
        return disponibiliteRepo.findById(id);
    }

    @Override
    public Disponibilite createDisponibilite(Disponibilite disponibilite) {
        return disponibiliteRepo.save(disponibilite);
    }

    @Override
    public Disponibilite updateDisponibilite(Long id, Disponibilite disponibiliteDetails) {
        Disponibilite disponibilite = disponibiliteRepo.findById(id).orElseThrow();
        disponibilite.setDate(disponibiliteDetails.getDate());
        disponibilite.setHeureDebut(disponibiliteDetails.getHeureDebut());
        disponibilite.setHeureFin(disponibiliteDetails.getHeureFin());
        disponibilite.setEtat(disponibiliteDetails.getEtat());
        disponibilite.setPraticien(disponibiliteDetails.getPraticien());
        return disponibiliteRepo.save(disponibilite);
    }

    @Override
    public void deleteDisponibilite(Long id) {
        disponibiliteRepo.deleteById(id);
    }
}
