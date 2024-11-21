package org.example.medecin_disponibilite;

import org.example.medecin_disponibilite.Entities.Disponibilite;
import org.example.medecin_disponibilite.Entities.Praticien;
import org.example.medecin_disponibilite.Entities.Specialite;
import org.example.medecin_disponibilite.Repositories.DisponibiliteRepo;
import org.example.medecin_disponibilite.Repositories.PraticienRepo;
import org.example.medecin_disponibilite.Repositories.SpecialiteRepo;
import org.example.medecin_disponibilite.config.MedecinDispoConfigParams;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(MedecinDispoConfigParams.class)
public class MedecinDisponibiliteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedecinDisponibiliteApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(PraticienRepo praticienRepo, DisponibiliteRepo disponibiliteRepo, SpecialiteRepo specialiteRepo) {
        return args -> {
            Specialite psychologie = new Specialite();
            psychologie.setNom("Psychologue");
            specialiteRepo.save(psychologie);

            Specialite generaliste = new Specialite();
            generaliste.setNom("Généraliste");
            specialiteRepo.save(generaliste);


            Disponibilite dispo1 = Disponibilite.builder()
                    .date(LocalDate.now())
                    .heureDebut(LocalTime.of(9, 0))
                    .heureFin(LocalTime.of(12, 0))
                    .etat("Available")
                    .build();

            Disponibilite dispo2 = Disponibilite.builder()
                    .date(LocalDate.now().plusDays(1))
                    .heureDebut(LocalTime.of(14, 0))
                    .heureFin(LocalTime.of(18, 0))
                    .etat("Available")
                    .build();

            disponibiliteRepo.save(dispo1);
            disponibiliteRepo.save(dispo2);


            Praticien praticien1 = Praticien.builder()
                    .nom("Ferdoussi")
                    .prenom("Aymen")
                    .specialite(psychologie)
                    .disponibilites(List.of(dispo1, dispo2))
                    .build();

            Praticien praticien2 = Praticien.builder()
                    .nom("Barodi")
                    .prenom("Farid")
                    .specialite(generaliste)
                    .disponibilites(List.of(dispo1))
                    .build();


            praticienRepo.save(praticien1);
            praticienRepo.save(praticien2);



        };
    }
}