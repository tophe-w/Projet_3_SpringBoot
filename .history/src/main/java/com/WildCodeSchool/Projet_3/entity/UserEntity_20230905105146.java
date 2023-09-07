package com.WildCodeSchool.Projet_3.entity; 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*; // importe toutes les annotations de jakarta.persistence grâce à l'étoile
 

@Entity
@Table(name = "user")
public class UserEntity {
 

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
  @JoinColumn(name = "role_id")
  private Role role;

    private String name;
    private String firstname;
    private String username;
    private String email;
    private String password;
    private Date birthday;
    private String avatar;
    private String color;
    private boolean is_available;
    private boolean is_connected;

     @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Message> messages;


    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }


    public UserEntity() {

    }

    public UserEntity(String name, String password, boolean is_connected, String email, Role role,Date birthday,String firstname, String username, 
            String avatar, String color, boolean is_available) {
        this.name = name;
        this.firstname = firstname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
        this.avatar = "avatar\AvatarH1.png;         //chemin avec son.png en enregistré dans le dossier ressources
        this.color = color;
        this.is_available = is_available;
        this.is_connected = is_connected;
        this.role = role;
    }

    


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
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


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public Role getRole() {
        return role;
      }
    
      public void setRole(Role role) {
        this.role = role;
      }
    



    public Date getBirthday() {
        return birthday;
    }


    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    public String getAvatar() {
        return avatar;
    }


    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }


    public boolean isIs_available() {
        return is_available;
    }


    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }


    public boolean isIs_connected() {
        return is_connected;
    }


    public void setIs_connected(boolean is_connected) {
        this.is_connected = is_connected;
    }

      public UserDetails asUserDetails() {
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(this.getRole().getType()));
    return User.withUsername(email)
        .password(password)
        .authorities(authorities)
        .build();
  }


    
}