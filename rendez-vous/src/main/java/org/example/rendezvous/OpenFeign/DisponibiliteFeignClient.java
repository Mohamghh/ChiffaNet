package org.example.rendezvous.OpenFeign;


import org.example.rendezvous.DTO.DisponibiliteDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.hateoas.PagedModel;

import java.util.List;


@FeignClient(name = "MEDECIN-DISPONIBILITE")
public interface DisponibiliteFeignClient {

    @GetMapping("/api/disponibilites/{id}")
    DisponibiliteDTO findDispoById(@PathVariable Long id);

    @GetMapping("/api/disponibilites")
    List<DisponibiliteDTO> getAllDisponibilites();


}

