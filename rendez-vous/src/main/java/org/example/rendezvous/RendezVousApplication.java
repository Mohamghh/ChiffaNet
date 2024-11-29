package org.example.rendezvous;

import org.example.rendezvous.Entities.Rendezvous;
import org.example.rendezvous.Repositories.RendezvousRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class RendezVousApplication {

	public static void main(String[] args) {
		SpringApplication.run(RendezVousApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RendezvousRepo rendezvousRepo) {
		return args -> {



			rendezvousRepo.save(Rendezvous.builder()
					.date(LocalDate.now())
					.heure(LocalTime.of(10, 30))
					.statut("Scheduled")
					.build());

			rendezvousRepo.save(Rendezvous.builder()

					.date(LocalDate.now().plusDays(1))
					.heure(LocalTime.of(15, 0))
					.statut("Confirmed")
					.build());
		};

	}
}
