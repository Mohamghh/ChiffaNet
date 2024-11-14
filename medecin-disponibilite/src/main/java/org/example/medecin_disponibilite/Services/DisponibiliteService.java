package org.example.medecin_disponibilite.Services;

import org.example.medecin_disponibilite.Entities.Disponibilite;

import java.util.List;
import java.util.Optional;

public interface DisponibiliteService {

    List<Disponibilite> getAllDisponibilites();
    Optional<Disponibilite> getDisponibiliteById(Long id);
    Disponibilite createDisponibilite(Disponibilite disponibilite);
    Disponibilite updateDisponibilite(Long id, Disponibilite disponibiliteDetails);
    void deleteDisponibilite(Long id);
}
