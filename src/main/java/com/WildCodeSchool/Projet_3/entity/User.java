package com.WildCodeSchool.Projet_3.entity; 

import java.util.Date;
import java.util.List;

import jakarta.persistence.*; // importe toutes les annotations de jakarta.persistence grâce à l'étoile
 

@Entity
public class User {
 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String firstname;
    private String pseudo;
    private String email;
    private String password;
    private boolean is_admin;
    private Date birthday;
    private String avatar;
    private String color;
    private boolean is_available;
    private boolean is_connected;

     @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Message> messages;


    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }


    public User() {

    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getFirstname() {
        return firstname;
    }


    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }


    public String getPseudo() {
        return pseudo;
    }


    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isIs_admin() {
        return is_admin;
    }


    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }


    public Date getBirthday() {
        return birthday;
    }


    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    public String getAvatar() {
        return avatar;
    }


    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public boolean isIs_available() {
        return is_available;
    }


    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }


    public boolean isIs_connected() {
        return is_connected;
    }


    public void setIs_connected(boolean is_connected) {
        this.is_connected = is_connected;
    }


    
}