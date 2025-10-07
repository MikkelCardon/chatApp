package com.ChatApp.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_")
public class User {

    @Id
    @GeneratedValue()
    private Integer user_id;

    private String username;

    @Column(unique = true)
    private String email;

    public Integer getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
