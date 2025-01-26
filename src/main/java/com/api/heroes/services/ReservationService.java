package com.api.heroes.services;

import com.api.heroes.models.ReservationModel;
import com.api.heroes.repositories.IReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private IReservationRepository repository;

    public List<ReservationModel> getAll() {
        return repository.findAll();
    }

    public Optional<ReservationModel> getById(Long id) {
        return repository.findById(id);
    }

    public ReservationModel create(ReservationModel entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public ReservationModel update(Long id, ReservationModel entity) {
        entity.setId(id);
        return repository.save(entity);
    }
}
