package com.Elliott.Engineering.Website.Models;

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
    private String tagNumber;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Cow cow;

    private boolean sex;


    public Calf(){}

    public Calf(String tagNumber,Cow cow){
        this.tagNumber = tagNumber;
        this.cow = cow;
    }

    public Calf(String tagNumber,Cow cow,String details,boolean sex){
        this.tagNumber = tagNumber;
        this.cow = cow;
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

    public String getTagNumber() {
        return tagNumber;
    }
    public Cow getCow(){
        return this.cow;
    }

    public Boolean getSex(){
        return this.sex;
    }

    //SETTERS
    public void setDetails(String details){
        this.details = details;
    }
    public void setTagNumber(String tagNumber){
        this.tagNumber = tagNumber;
    }
    public void setCow(Cow cow){
        this.cow = cow;
    }
    public void setSex(Boolean sex){
        this.sex = sex;
    }
}
