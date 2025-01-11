package com.api.heroes.services;

import com.api.heroes.models.ChatRoomModel;
import com.api.heroes.repositories.IChatRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatRoomService {
    @Autowired
    private IChatRoomRepository repository;

    public List<ChatRoomModel> getAll() {
        return repository.findAll();
    }

    public Optional<ChatRoomModel> getById(Long id) {
        return repository.findById(id);
    }

    public ChatRoomModel create(ChatRoomModel entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public ChatRoomModel update(Long id, ChatRoomModel entity) {
        entity.setId(id);
        return repository.save(entity);
    }
}
