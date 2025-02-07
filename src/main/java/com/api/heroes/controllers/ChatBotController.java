package com.api.heroes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import com.api.heroes.services.ChatBotService;

@Controller
public class ChatBotController {
    @Autowired
    private ChatBotService chatBotService;

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public String sendMessage(String message) {
        return chatBotService.getResponse(message);
    }
}
