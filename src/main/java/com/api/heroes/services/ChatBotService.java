package com.api.heroes.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.heroes.repositories.IChatBotRepository;

@Service
public class ChatBotService {
    @Autowired
    private IChatBotRepository chatBotRepository;

    public String getResponse(String message) {
        String response = chatBotRepository.findByPromptContaining(message).getResponse();
        return response;
    }
}
