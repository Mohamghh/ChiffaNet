package org.example.medecin_disponibilite.Services;

import org.example.medecin_disponibilite.Entities.Praticien;

import java.util.List;
import java.util.Optional;

public interface PraticienService {

    List<Praticien> getAllPraticiens();
    Optional<Praticien> getPraticienById(Long id);
    Praticien createPraticien(Praticien praticien);
    Praticien updatePraticien(Long id, Praticien praticienDetails);
}
