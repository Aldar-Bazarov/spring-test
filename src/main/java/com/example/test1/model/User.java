package com.example.test1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class User {
    private final UUID id;
    private String username;
    private String password;

    public User(@JsonProperty("id") UUID id,
                @JsonProperty("username") String username,
                @JsonProperty("password") String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}