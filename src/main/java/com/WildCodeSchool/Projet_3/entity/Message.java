package com.WildCodeSchool.Projet_3.entity;


import jakarta.persistence.*;

@Entity
public class Message { 
    @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)

 private int id;
    private String message;
   

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

        

}

