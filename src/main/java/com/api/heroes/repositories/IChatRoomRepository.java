package com.api.heroes.repositories;

import com.api.heroes.models.ChatRoomModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChatRoomRepository extends JpaRepository<ChatRoomModel, Long> {
}
