package com.Elliott.Engineering.Website.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Herd {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private User users;

    @OneToMany(mappedBy = "herd",orphanRemoval = true,cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<Cow> cowList = new ArrayList<>();

    @Column
    private String name;

    @Column
    private String details;



    public Herd() {
    }

    public Herd(String name,User user){
        this.name = name;
        this.users = user;
    }
    public Herd(String name,User user,String details){
        this.name = name;
        this.users = user;
        this.details = details;
    }


    //GETTER METHODS
    public Long getId(){
        return this.id;
    }
    public User getUsers(){
        return this.users;
    }
    public List<Cow> getCowList(){
        return this.cowList;
    }
    public String getName(){
        return this.name;
    }
    public String getDetails(){
        return this.details;
    }
    //SETTERS
    public void setUsers(User user){
        this.users = user;
    }
    public void setName(String name){
        this.name = name;
    }
    public void addCow(Cow cow){
        this.cowList.add(cow);
    }
    public void getDetails(String details){
        this.details = details;
    }


}
