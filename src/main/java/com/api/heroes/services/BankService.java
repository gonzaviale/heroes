package com.api.heroes.services;

import com.api.heroes.models.BankModel;
import com.api.heroes.repositories.IBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {
    @Autowired
    private IBankRepository repository;

    public List<BankModel> getAll() {
        return repository.findAll();
    }

    public Optional<BankModel> getById(Long id) {
        return repository.findById(id);
    }

    public BankModel create(BankModel entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public BankModel update(Long id, BankModel entity) {
        entity.setId(id);
        return repository.save(entity);
    }
}
