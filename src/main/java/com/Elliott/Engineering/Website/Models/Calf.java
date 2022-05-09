package com.Elliott.Engineering.Website.Models;

import com.Elliott.Engineering.Website.Models.Types.CalfTypes;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Calf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String details;

    @Column
    private String calfTagNumber;

    @Column
    private String cowTagNumber;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private User users;

    @Column
    @Enumerated(EnumType.STRING)
    private CalfTypes sex;


    public Calf(){}


    public Calf(String calfTagNumber, String cowTagNumber, String details, CalfTypes sex){
        this.calfTagNumber = calfTagNumber;
        this.cowTagNumber = cowTagNumber;
        this.details = details;
        this.sex = sex;
    }

    //GETTERS
    public Long getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }

    public String getCalfTagNumber() {
        return calfTagNumber;
    }
    public String getCowTagNumber() {
        return cowTagNumber;
    }
    public User getUser(){
        return this.users;
    }

    public CalfTypes getSex(){
        return this.sex;
    }

    //SETTERS
    public void setDetails(String details){
        this.details = details;
    }
    public void setCalfTagNumber(String tagNumber){
        this.calfTagNumber = tagNumber;
    }
    public void setCowTagNumber(String tagNumber){
        this.cowTagNumber = tagNumber;
    }
    public void setUser(User user){
        this.users = user;
    }
    public void setSex(CalfTypes sex){
        this.sex = sex;
    }
}
