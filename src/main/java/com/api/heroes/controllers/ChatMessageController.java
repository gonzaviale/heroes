package com.api.heroes.controllers;

import com.api.heroes.models.ChatMessageModel;
import com.api.heroes.services.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chatmessage")
public class ChatMessageController {
    @Autowired
    private ChatMessageService service;

    @GetMapping
    public List<ChatMessageModel> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ChatMessageModel> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ChatMessageModel create(@RequestBody ChatMessageModel entity) {
        return service.create(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public ChatMessageModel update(@PathVariable Long id, @RequestBody ChatMessageModel entity) {
        return service.update(id, entity);
    }
}
