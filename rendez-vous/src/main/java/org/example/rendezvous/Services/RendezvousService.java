package org.example.rendezvous.Services;

import org.example.rendezvous.Entities.Rendezvous;

import java.util.List;
import java.util.Optional;

public interface RendezvousService {

    Rendezvous createRendezVous(Rendezvous rendezVous);
    Rendezvous updateRendezVous(Long id, Rendezvous updatedRendezVous);
    void deleteRendezVous(Long id);
    Optional<Rendezvous> getRendezVousById(Long id);
    List<Rendezvous> getAllRendezVous();
}
