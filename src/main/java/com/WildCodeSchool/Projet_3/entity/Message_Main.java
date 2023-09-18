package com.WildCodeSchool.Projet_3.entity;

import jakarta.persistence.*; // importe toutes les annotations de jakarta.persistence grâce à l'étoile

@Entity
public class Message_Main {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
   
    // @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    // @JoinColumn(name = "USER_id")
       private String user;
   
       
       private String message;
       private String roomName;
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
      
      public String getRoomName() {
           return roomName;
       }

       public void setRoomName(String roomName) {
           this.roomName = roomName;
       }
   
       public String getUser() {
           return user;
       }
   
       public void setUser(String string) {
           this.user = string;
       }
   
   
       public String getHeure() {
           return heure;
       }
   
       public void setHeure(String heure) {
           this.heure = heure;
       }
    
}
