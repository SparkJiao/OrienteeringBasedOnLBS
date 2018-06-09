package com.sdu.kkkkk.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kkkkk on 2018/6/4.
 */
@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gid;
    private String name;
    private String creator;
    private Date time;
    private String image;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Group(){}
    
    public Group(String name, String creator, String image){
        this.name = name;
        this.creator = creator;
        this.image = image;
    }
    
}
