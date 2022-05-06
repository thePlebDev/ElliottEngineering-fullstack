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

    @Temporal(TemporalType.DATE)
    @Column
    private Date dateBorn;

    @Column
    private String tagNumber;

    @ManyToOne
    @JoinColumn
    private Cow cow;


    public Calf(){}

    public Calf(String tagNumber,Cow cow){
        this.tagNumber = tagNumber;
        this.cow = cow;
    }

    public Calf(String tagNumber,Cow cow, String details,Date date){
        this.tagNumber = tagNumber;
        this.cow = cow;
        this.details = details;
        this.dateBorn = date;
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

    public Date getDateBorn() {
        return dateBorn;
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
}
