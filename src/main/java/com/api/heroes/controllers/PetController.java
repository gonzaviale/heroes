package com.api.heroes.controllers;

import com.api.heroes.models.PetModel;
import com.api.heroes.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService service;

    @GetMapping
    public List<PetModel> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<PetModel> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public PetModel create(@RequestBody PetModel entity) {
        return service.create(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public PetModel update(@PathVariable Long id, @RequestBody PetModel entity) {
        return service.update(id, entity);
    }
}
