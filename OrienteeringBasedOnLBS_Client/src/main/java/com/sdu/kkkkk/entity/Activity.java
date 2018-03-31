package com.sdu.kkkkk.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by kkkkk on 2018/4/1.
 */
@Entity
@Table(name = "activity")
public class Activity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    private Date time;
    private String splace;
    private String epalce;
    private int sid;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSplace() {
        return splace;
    }

    public void setSplace(String splace) {
        this.splace = splace;
    }

    public String getEpalce() {
        return epalce;
    }

    public void setEpalce(String epalce) {
        this.epalce = epalce;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }


}
