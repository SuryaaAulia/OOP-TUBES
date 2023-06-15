package com.QuiZZila.Tubes.main.model;

import javax.persistence.*;

@Entity
public class Users {
    private String password;
    @Column(unique = true)
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Users(){

    }
    public Users(String pass, String email) {
        this.password = pass;
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}