package com.api.heroes.repositories;

import com.api.heroes.models.ChatMessageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChatMessageRepository extends JpaRepository<ChatMessageModel, Long> {
}
