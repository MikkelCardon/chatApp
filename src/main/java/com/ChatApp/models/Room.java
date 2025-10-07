package com.ChatApp.models;

import jakarta.persistence.*;

import java.util.Random;

@Entity
public class Room {

    @Id
    @Column(length = 8)
    private String room_id;

    private String name;

    @PrePersist
    public void generateId() {
        if (this.room_id == null) {
            this.room_id = generateRoomCode();
        }
    }

    private String generateRoomCode() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder code = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 8; i++) {
            code.append(chars.charAt(random.nextInt(chars.length())));
        }

        return code.toString();
    }


}
