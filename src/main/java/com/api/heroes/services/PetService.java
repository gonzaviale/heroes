package com.api.heroes.services;

import com.api.heroes.models.PetModel;
import com.api.heroes.repositories.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private IPetRepository repository;

    public List<PetModel> getAll() {
        return repository.findAll();
    }

    public Optional<PetModel> getById(Long id) {
        return repository.findById(id);
    }

    public PetModel create(PetModel entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public PetModel update(Long id, PetModel entity) {
        entity.setId(id);
        return repository.save(entity);
    }

}
