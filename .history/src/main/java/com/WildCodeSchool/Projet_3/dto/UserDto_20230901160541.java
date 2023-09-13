package com.WildCodeSchool.Projet_3.dto;

import java.sql.Date;

public class UserDto {
  private int id;
  private String username;
  private String firstname;
  private String name;
  private Date birthday; 
  private String password;
  private String email;
  private String role;
 

  public UserDto() {
  }





  public String getNameId() {
    return ;
}


public void setName(String name) {
    this.name = name;
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


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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
