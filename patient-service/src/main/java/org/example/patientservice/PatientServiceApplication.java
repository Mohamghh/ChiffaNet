package org.example.patientservice;

import org.example.patientservice.Entities.Patient;
import org.example.patientservice.Repositories.PatientRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PatientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner(PatientRepo patientRepo){
        return args -> {
            patientRepo.save(Patient.builder()
                            .nom("Mohamed").prenom("Amine").email("moha@gmail.com").numeroTelephone("0766854123")
                            .adresse("Bournazel")
                    .build());

            patientRepo.save(Patient.builder()
                    .nom("Barodi").prenom("Farid").email("farid@gmail.com").numeroTelephone("0766874123")
                    .adresse("Medina")
                    .build());

            patientRepo.save(Patient.builder()
                    .nom("Fayl").prenom("Fouad").email("fayl@gmail.com").numeroTelephone("0587736514")
                    .adresse("Hay amal")
                    .build());

            patientRepo.findAll().forEach(p -> {
                System.out.println("-----------------------");
                System.out.println(p.getId());
                System.out.println(p.getNom());
                System.out.println(p.getPrenom());
                System.out.println(p.getEmail());
                System.out.println(p.getNumeroTelephone());
                System.out.println("-----------------------");
            });

        };
    }

}
