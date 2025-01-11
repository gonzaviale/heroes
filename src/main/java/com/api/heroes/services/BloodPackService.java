package com.api.heroes.services;

import com.api.heroes.models.BloodPackModel;
import com.api.heroes.repositories.IBloodPackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BloodPackService {
    @Autowired
    private IBloodPackRepository repository;

    public List<BloodPackModel> getAll() {
        return repository.findAll();
    }

    public Optional<BloodPackModel> getById(Long id) {
        return repository.findById(id);
    }

    public BloodPackModel create(BloodPackModel entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public BloodPackModel update(Long id, BloodPackModel entity) {
        entity.setId(id);
        return repository.save(entity);
    }
}
