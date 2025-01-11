package com.api.heroes.models;

import jakarta.persistence.*;

import java.util.Date;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ChatRoomModel getChatRoom() {
        return chatRoom;
    }

    public void setChatRoom(ChatRoomModel chatRoom) {
        this.chatRoom = chatRoom;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
