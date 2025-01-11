package com.api.heroes.services;

import com.api.heroes.models.ChatMessageModel;
import com.api.heroes.repositories.IChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatMessageService {
    @Autowired
    private IChatMessageRepository repository;

    public List<ChatMessageModel> getAll() {
        return repository.findAll();
    }

    public Optional<ChatMessageModel> getById(Long id) {
        return repository.findById(id);
    }

    public ChatMessageModel create(ChatMessageModel entity) {
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public ChatMessageModel update(Long id, ChatMessageModel entity) {
        entity.setId(id);
        return repository.save(entity);
    }
}
