package com.api.heroes.controllers;

import com.api.heroes.models.BloodPackModel;
import com.api.heroes.services.BloodPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bloodpack")
public class BloodPackController {
    @Autowired
    private BloodPackService service;

    @GetMapping
    public List<BloodPackModel> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<BloodPackModel> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public BloodPackModel create(@RequestBody BloodPackModel entity) {
        return service.create(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public BloodPackModel update(@PathVariable Long id, @RequestBody BloodPackModel entity) {
        return service.update(id, entity);
    }

    @GetMapping("/getByBank/{id}")
    public List<BloodPackModel> getByBank(@PathVariable Long id){
        return service.getByBank(id);
    }
}
