package com.WildCodeSchool.Projet_3.dto;

public class UserMessageDto {


    private int id;
  private String username;
  private String firstname;
  private boolean is_connected;
  private boolean is_available;

    public UserMessageDto() {
    }


public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getUsername() {
    return username;
}
public void setUsername(String username) {
    this.username = username;
}
public String getFirstname() {
    return firstname;
}
public void setFirstname(String firstname) {
    this.firstname = firstname;
}
public boolean isIs_connected() {
    return is_connected;
}
public void setIs_connected(boolean is_connected) {
    this.is_connected = is_connected;
}
public boolean isIs_available() {
    return is_available;
}
public void setIs_available(boolean is_available) {
    this.is_available = is_available;
}
    
}
