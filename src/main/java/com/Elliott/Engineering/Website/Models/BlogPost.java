package com.Elliott.Engineering.Website.Models;

import com.Elliott.Engineering.Website.Models.Types.BlogPostTags;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "blog_post")
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;


    @Column
    private String body;

    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date date;


    public BlogPost() {
    }

    public BlogPost(String title, String body){
        this.title = title;
        this.body = body;
    }


    //GETTERS
    public String getTitle(){
        return this.title;
    }
    public String getBody(){
        return this.title;
    }
    public Long getId(){
        return this.id;
    }
    public Date getDate(){
        return this.date;
    }

    //SETTERS
    public void setTitle(String title){
        this.title = title;
    }
    public void setBody(String body){
        this.body = body;
    }
    public void setDate(Date date){
        this.date = date;
    }



}
