package com.sdu.kkkkk.models;

import java.io.Serializable;

/**
 * Created by kkkkk on 2018/6/6.
 */
public class Location implements Serializable{

    private String sid;
    private String image;
    private String longitude;
    private String latitude;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Location(String sid, String image, String longitude, String latitude){
        this.sid = sid;
        this.image = image;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public Location(){}

    public String getLongitude(){
        return this.longitude;
    }

    public String getLatitude(){
        return this.latitude;
    }

    public void setLongitude(String longitude){
        this.longitude = longitude;
    }

    public void setLatitude(String latitude){
        this.latitude = latitude;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
