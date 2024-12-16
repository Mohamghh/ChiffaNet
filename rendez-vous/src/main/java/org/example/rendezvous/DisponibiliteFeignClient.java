package org.example.rendezvous;


import org.example.rendezvous.Entities.DisponibiliteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "MEDECIN-DISPONIBILITE")
public interface DisponibiliteFeignClient {

    @GetMapping("/api/disponibilites/praticien/{praticienId}")
    List<DisponibiliteDTO> getDisponibilitesByPraticienId(@PathVariable("praticienId") Long praticienId);


}

