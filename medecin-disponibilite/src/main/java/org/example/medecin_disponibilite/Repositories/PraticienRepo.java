package org.example.medecin_disponibilite.Repositories;

import org.example.medecin_disponibilite.Entities.Praticien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PraticienRepo extends JpaRepository<Praticien, Long> {
}
