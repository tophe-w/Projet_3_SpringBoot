package com.WildCodeSchool.Projet_3.entity;

import jakarta.persistence.*;

@Entity
public class Message_global {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

         @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
         @JoinColumn(name = "user_id")
             private UserEntity user_id;





            private String message;
            private String date;
            private String heure;
            
            public int getId() {
                return id;
            }
            public void setId(int id) {
                this.id = id;
            }
            public UserEntity getUser_id() {
                return user_id;
            }
            public void setUser_id(UserEntity user_id) {
                this.user_id = user_id;
            }
            public String getMessage() {
                return message;
            }
            public void setMessage(String message) {
                this.message = message;
            }
            public String getDate() {
                return date;
            }
            public void setDate(String date) {
                this.date = date;
            }
            public String getHeure() {
                return heure;
            }
            public void setHeure(String heure) {
                this.heure = heure;
            }
    
}