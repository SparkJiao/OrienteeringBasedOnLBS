package com.sdu.kkkkk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by kkkkk on 2018/6/10.
 */
@Entity
@Table(name = "like")
@IdClass(LikesKey.class)
public class Like {

    @Id
    private int tid;
    @Id
    private String sid;
    private String name;
    private String image;
    private Date time;

    public Like(int tid, String sid, String name, String image) {
        this.tid = tid;
        this.sid = sid;
        this.name = name;
        this.image = image;
    }

    public Like() {
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
