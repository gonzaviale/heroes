package com.api.heroes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.heroes.models.ChatBotModel;

public interface IChatBotRepository extends JpaRepository<ChatBotModel, Long> {

    ChatBotModel findByPromptContaining(String message);

}
