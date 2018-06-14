package com.sdu.kkkkk.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kkkkk on 2018/6/4.
 */
@Entity
@Table(name = "wechat")
public class Wechat {
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

    public Wechat(){}
    
    public Wechat(String name, String creator){
        this.name = name;
        this.creator = creator;
        this.image = "50a2899158de413483fd4472d005121f.jpg";
    }
    
}
