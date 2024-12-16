package org.example.rendezvous.Entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;


@Getter @Setter
public class DisponibiliteDTO {

    private Long id;
    private LocalDate date;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private String etat;


}
