package org.example.rendezvous.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rendezvous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long praticienId;
    private Long patientId;
    private LocalDate date;
    private LocalTime heure;
    private String statut;
    private Long disponibiliteId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDisponibiliteId() {
        return disponibiliteId;
    }

    public void setDisponibiliteId(Long disponibiliteId) {
        this.disponibiliteId = disponibiliteId;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getPraticienId() {
        return praticienId;
    }

    public void setPraticienId(Long praticienId) {
        this.praticienId = praticienId;
    }
}
