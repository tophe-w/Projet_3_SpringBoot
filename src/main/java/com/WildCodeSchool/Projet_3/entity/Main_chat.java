package com.WildCodeSchool.Projet_3.entity;

import jakarta.persistence.*; // importe toutes les annotations de jakarta.persistence grâce à l'étoile

@Entity
public class Main_chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int train_number;
    

    public int getTrain_number() {
        return train_number;
    }

    public void setTrain_number(int train_number) {
        this.train_number = train_number;
    }
    
}
