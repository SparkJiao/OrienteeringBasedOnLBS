package com.sdu.kkkkk.models;

import java.io.Serializable;

/**
 * Created by kkkkk on 2018/6/6.
 */
public class Userinfo implements Serializable{

    public Userinfo(String sid, String image, String name) {
        this.sid = sid;
        this.image = image;
        this.name = name;
    }

    private String sid;
    private String image;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Userinfo() {
    }
}
