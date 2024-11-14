package org.example.medecin_disponibilite.Repositories;

import org.example.medecin_disponibilite.Entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialiteRepo extends JpaRepository<Specialite, Long> {
}
