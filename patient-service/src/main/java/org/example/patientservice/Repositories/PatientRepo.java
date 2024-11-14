package org.example.patientservice.Repositories;

import org.example.patientservice.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource
public interface PatientRepo extends JpaRepository<Patient, Long> {
}
