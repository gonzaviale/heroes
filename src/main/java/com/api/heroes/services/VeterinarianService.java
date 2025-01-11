package com.api.heroes.services;

import com.api.heroes.models.VeterinarianModel;
import com.api.heroes.repositories.IVeterinarianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarianService {
    @Autowired
    private IVeterinarianRepository repository;

    public List<VeterinarianModel> getAll() {
        return repository.findAll();
    }

    public Optional<VeterinarianModel> getById(Long id) {
        return repository.findById(id);
    }

    public VeterinarianModel create(VeterinarianModel entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public VeterinarianModel update(Long id, VeterinarianModel entity) {
        entity.setId(id);
        return repository.save(entity);
    }
}
