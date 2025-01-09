package com.api.heroes.controllers;

import com.api.heroes.models.BankModel;
import com.api.heroes.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    private BankService service;

    @GetMapping
    public List<BankModel> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<BankModel> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public BankModel create(@RequestBody BankModel entity) {
        return service.create(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public BankModel update(@PathVariable Long id, @RequestBody BankModel entity) {
        return service.update(id, entity);
    }
}
