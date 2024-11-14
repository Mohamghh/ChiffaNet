package org.example.medecin_disponibilite.Services;

import org.example.medecin_disponibilite.Entities.Specialite;
import org.example.medecin_disponibilite.Repositories.SpecialiteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SpecialiteServiceImpl implements SpecialiteService {
    @Autowired
    private SpecialiteRepo specialiteRepo;

    @Override
    public List<Specialite> getAllSpecialites() {
        return specialiteRepo.findAll();
    }

    @Override
    public Optional<Specialite> getSpecialiteById(Long id) {
        return specialiteRepo.findById(id);
    }

    @Override
    public Specialite createSpecialite(Specialite specialite) {
        return specialiteRepo.save(specialite);
    }
}
