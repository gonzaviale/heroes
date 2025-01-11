package com.api.heroes.controllers;

import com.api.heroes.models.VeterinarianModel;
import com.api.heroes.services.VeterinarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veterinarian")
public class VeterinarianController {
    @Autowired
    private VeterinarianService service;

    @GetMapping
    public List<VeterinarianModel> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<VeterinarianModel> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public VeterinarianModel create(@RequestBody VeterinarianModel entity) {
        return service.create(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public VeterinarianModel update(@PathVariable Long id, @RequestBody VeterinarianModel entity) {
        return service.update(id, entity);
    }
}
