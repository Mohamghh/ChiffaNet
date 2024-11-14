package org.example.medecin_disponibilite;

import org.example.medecin_disponibilite.config.MedecinDispoConfigParams;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(MedecinDispoConfigParams.class)
public class MedecinDisponibiliteApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedecinDisponibiliteApplication.class, args);
    }

}
