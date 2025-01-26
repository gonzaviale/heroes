package com.api.heroes.controllers;

import com.api.heroes.models.ReservationModel;
import com.api.heroes.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    @Autowired
    private ReservationService service;

    @GetMapping
    public List<ReservationModel> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ReservationModel> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ReservationModel create(@RequestBody ReservationModel entity) {
        return service.create(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public ReservationModel update(@PathVariable Long id, @RequestBody ReservationModel entity) {
        return service.update(id, entity);
    }
}
