package com.api.heroes.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "chatmessage")
public class ChatMessageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @ManyToOne
    @JoinColumn(name = "chatroom_id")
    private ChatRoomModel chatRoom;
    @ManyToOne
    private UserModel user;
    private Date date;
    private String status;
    private String type;
    private String file;

}
