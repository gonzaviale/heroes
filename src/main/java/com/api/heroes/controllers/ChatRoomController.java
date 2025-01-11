package com.api.heroes.controllers;

import com.api.heroes.models.ChatRoomModel;
import com.api.heroes.services.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/chatroom")
public class ChatRoomController {
    @Autowired
    private ChatRoomService service;

    @GetMapping
    public List<ChatRoomModel> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ChatRoomModel> getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public ChatRoomModel create(@RequestBody ChatRoomModel entity) {
        return service.create(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/{id}")
    public ChatRoomModel update(@PathVariable Long id, @RequestBody ChatRoomModel entity) {
        return service.update(id, entity);
    }
}
