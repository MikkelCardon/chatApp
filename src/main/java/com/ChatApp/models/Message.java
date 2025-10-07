package com.ChatApp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue
    private Integer message_id;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room roomId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User fromUser;

    private String message;


    public Integer getId() {
        return message_id;
    }

    public Room getRoomId() {
        return roomId;
    }

    public void setRoomId(Room roomId) {
        this.roomId = roomId;
    }

    public User getFromUser() {
        return fromUser;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
