package org.example.medecin_disponibilite.Services;

import org.example.medecin_disponibilite.Entities.Praticien;
import org.example.medecin_disponibilite.Entities.Specialite;

import java.util.List;
import java.util.Optional;

public interface SpecialiteService {

    List<Specialite> getAllSpecialites();
    Optional<Specialite> getSpecialiteById(Long id);
    Specialite createSpecialite(Specialite specialite);
}
