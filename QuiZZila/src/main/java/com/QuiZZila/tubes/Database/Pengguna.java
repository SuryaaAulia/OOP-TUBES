package com.QuiZZila.tubes.Database;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "pengguna")
public class Pengguna implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "email")
    private String email;
    @Column(name = "username")
    private String username;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
