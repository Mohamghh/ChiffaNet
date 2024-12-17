package org.example.rendezvous.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.rendezvous.DTO.DisponibiliteDTO;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
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
    @Transient
    private DisponibiliteDTO disponibilite;


}
