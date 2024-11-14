package org.example.medecin_disponibilite.Repositories;

import org.example.medecin_disponibilite.Entities.Disponibilite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DisponibiliteRepo extends JpaRepository<Disponibilite, Long> {

    List<Disponibilite> findByPraticienIdAndDate(Long praticienId, LocalDate date);
}
