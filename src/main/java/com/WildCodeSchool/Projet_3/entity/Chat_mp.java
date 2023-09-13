package com.WildCodeSchool.Projet_3.entity;

import jakarta.persistence.*; // importe toutes les annotations de jakarta.persistence grâce à l'étoile


@Entity
public class Chat_mp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    
}
