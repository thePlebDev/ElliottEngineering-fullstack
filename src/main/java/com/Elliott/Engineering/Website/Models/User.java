package com.Elliott.Engineering.Website.Models;

import javax.persistence.*;

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String authority;


    public User() {
    }

    public User(String username, String password, String email,String authority){
        this.username = username;
        this.password = password;
        this.email = email;
        this.authority = authority;
    }

    //GETTERS
    public String getUsername(){
        return this.username;
    }
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return this.email;
    }
    public String getAuthority(){
        return this.authority;
    }
    public Long getId(){
        return this.id;
    }



    //SETTERS
    public void setUsername(String username){
        this.username = username;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setAuthority(String authority){
        this.authority = authority;
    }
}
