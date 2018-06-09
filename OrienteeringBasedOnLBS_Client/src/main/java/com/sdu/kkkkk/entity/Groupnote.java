package com.sdu.kkkkk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by kkkkk on 2018/6/4.
 */
@Entity
@Table(name = "groupnote")
public class Groupnote {

    public int getGnid() {
        return gnid;
    }

    public void setGnid(int gnid) {
        this.gnid = gnid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Id
    private int gnid;
    private int gid;
    private String sid;
    private String category;
    private String content;
    private Date time;

    public Groupnote(){}

    public Groupnote(int gid,String sid, String category, String content){
        this.gid = gid;
        this.sid = sid;
        this.category = category;
        this.content = content;
    }
}
