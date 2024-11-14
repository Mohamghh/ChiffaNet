package org.example.medecin_disponibilite.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "medecin.params")
public record MedecinDispoConfigParams(int x, int y) {
}
