package com.api.heroes.services;

import com.api.heroes.models.BankModel;
import com.api.heroes.models.BloodPackModel;
import com.api.heroes.models.enumerators.BloodPackStatus;
import com.api.heroes.repositories.IBankRepository;
import com.api.heroes.repositories.IBloodPackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BloodPackService {
    @Autowired
    private IBloodPackRepository repository;
    @Autowired
    private IBankRepository bankRepository;

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

    public List<BloodPackModel>getByBank(Long id){
        Optional<BankModel> bank = bankRepository.findById(id);
        return bank.map(bankModel -> repository.getBloodPackModelsByBank(bankModel)
                .stream()
                .filter(bloodPackModel -> bloodPackModel.getStatus() != BloodPackStatus.SOLD)
                .toList()).orElseGet(ArrayList::new);
    }
}
