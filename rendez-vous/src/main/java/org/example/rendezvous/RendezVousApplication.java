package org.example.rendezvous;

import com.thoughtworks.xstream.converters.time.LocalTimeConverter;
import org.example.rendezvous.DTO.DisponibiliteDTO;
import org.example.rendezvous.Entities.Rendezvous;
import org.example.rendezvous.OpenFeign.DisponibiliteFeignClient;
import org.example.rendezvous.Repositories.RendezvousRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class RendezVousApplication {

	public static void main(String[] args) {
		SpringApplication.run(RendezVousApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RendezvousRepo rendezvousRepo, DisponibiliteFeignClient disponibiliteFeignClient) {


		return args -> {
			List<DisponibiliteDTO> disponibilites = disponibiliteFeignClient.getAllDisponibilites();


			disponibilites.forEach(disponibilite -> {

				Rendezvous rendezvous = Rendezvous.builder()
						.heure(LocalTime.now())
						.disponibiliteId(disponibilite.getId())
						.statut(disponibilite.getEtat())
						.date(disponibilite.getDate())

						.build();
				rendezvousRepo.save(rendezvous);
			});


		};
	}
}

