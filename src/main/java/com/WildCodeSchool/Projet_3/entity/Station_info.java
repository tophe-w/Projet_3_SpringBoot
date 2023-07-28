package com.WildCodeSchool.Projet_3.entity;

import jakarta.persistence.*; // importe toutes les annotations de jakarta.persistence grâce à l'étoile



@Entity
public class Station_info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code_uic;
    private String station_name;

    
    public int getCode_uic() {
        return code_uic;
    }
    public void setCode_uic(int code_uic) {
        this.code_uic = code_uic;
    }
    public String getStation_name() {
        return station_name;
    }
    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    
}
