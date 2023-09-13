package com.WildCodeSchool.Projet_3.entity;


import jakarta.persistence.*;

@Entity
public class Message { 
    @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)

 private int id;
    private String message;
    private boolean is_private ;
    private String user_receiver;

 @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    public UserEntity getUser() {
    return user;        
}
    public void setUser(UserEntity user) {
    this.user = user;
}
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
    public boolean isIs_private() {
        return is_private;
    }
    public void setIs_private(boolean is_private) {
        this.is_private = is_private;
    }
    public String getUser_receiver() {
        return user_receiver;
    }
    public void setUser_receiver(String user_receiver) {
        this.user_receiver = user_receiver;
    }
    

    

}

