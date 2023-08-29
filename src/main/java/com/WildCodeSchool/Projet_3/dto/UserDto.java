package com.WildCodeSchool.Projet_3.dto;

import java.sql.Date;

public class UserDto {
  private String pseudo;
  private String firstname;
  private String name;
  private Date birthday; 
  private String password;
  private String email;
  private String role;
 

  public UserDto() {
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


public Date getBirthday() {
  return birthday;
}


public void setBirthday(Date birthday) {
  this.birthday = birthday;
}


  public String getPseudo() {
    return pseudo;
  }

  public void setPseudo(String pseudo) {
    this.pseudo = pseudo;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }



}
