package com.Elliott.Engineering.Website.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Herd herd;

    @OneToMany(mappedBy = "cow",fetch = FetchType.EAGER,orphanRemoval = true,cascade = CascadeType.PERSIST)
    private List<Calf> calfList = new ArrayList<Calf>();

    @Column
    private String tagNumber;

    @Column
    private String details;



    public Cow(){}
    public Cow(Herd herd,String tagNumber,String details,Calf calf){
        this.herd = herd;
        this.details = details;
        this.tagNumber = tagNumber;
        this.calfList.add(calf);
    }

    public Cow(Herd herd,String tagNumber,String details){
        this.herd = herd;
        this.details = details;
        this.tagNumber = tagNumber;
    }
    public Cow(Herd herd,String tagNumber){
        this.herd = herd;
        this.tagNumber = tagNumber;
    }

    //GETTERS
    public Long getId(){
        return this.id;
    }
    public Herd getHerd(){
        return this.herd;
    }
    public List<Calf> getCalfList(){
        return this.calfList;
    }
    public String getTagNumber() {
        return tagNumber;
    }
    public String getDetails() {
        return details;
    }

    //SETTERS
    public void setHerd(Herd herd){
        this.herd = herd;
    }
    public void setTagNumber(String tagNumber){
        this.tagNumber = tagNumber;
    }
    public void setDetails(String details){
        this.details = details;
    }
    public void addCalf(Calf calf){
        this.calfList.add(calf);
    }
}
