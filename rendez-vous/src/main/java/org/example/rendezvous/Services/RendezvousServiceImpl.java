package org.example.rendezvous.Services;

import org.example.rendezvous.Entities.Rendezvous;
import org.example.rendezvous.Repositories.RendezvousRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RendezvousServiceImpl implements RendezvousService {
    @Autowired
    private RendezvousRepo rendezvousRepo;

    @Override
    public Rendezvous createRendezVous(Rendezvous rendezVous) {
        return rendezvousRepo.save(rendezVous);
    }

    @Override
    public Rendezvous updateRendezVous(Long id, Rendezvous updatedRendezVous) {
        Optional<Rendezvous> existingRendezVousOpt = rendezvousRepo.findById(id);
        if (existingRendezVousOpt.isPresent()) {
            Rendezvous existingRendezVous = existingRendezVousOpt.get();
            existingRendezVous.setPraticienId(updatedRendezVous.getPraticienId());
            existingRendezVous.setDate(updatedRendezVous.getDate());
            existingRendezVous.setHeure(updatedRendezVous.getHeure());
            existingRendezVous.setStatut(updatedRendezVous.getStatut());
            return rendezvousRepo.save(existingRendezVous);
        }
        return null;
    }

    @Override
    public void deleteRendezVous(Long id) {
        rendezvousRepo.deleteById(id);
    }

    @Override
    public Optional<Rendezvous> getRendezVousById(Long id) {
        return rendezvousRepo.findById(id);
    }

    @Override
    public List<Rendezvous> getAllRendezVous() {
        return rendezvousRepo.findAll();
    }
}

