package com.WildCodeSchool.Projet_3.entity;


import jakarta.persistence.*;

@Entity
public class Message { 
    @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String message;
    private String user;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }

 

    
}

