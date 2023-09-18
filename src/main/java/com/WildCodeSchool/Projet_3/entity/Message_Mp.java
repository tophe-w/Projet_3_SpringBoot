package com.WildCodeSchool.Projet_3.entity;


import jakarta.persistence.*;

@Entity
public class Message_Mp { 



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


 @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
 @JoinColumn(name = "user_id")
    private UserEntity user_id;

    
    private String message;
    private int userReceiver;
    private String heure;

    
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
   
    public int getUserReceiver() {
        return userReceiver;
    }

    public void setUserReceiver(int userReceiver) {
        this.userReceiver = userReceiver;
    }

    public UserEntity getUser() {
        return user_id;
    }

    public void setUser(UserEntity user) {
        this.user_id = user;
    }


    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    
}

