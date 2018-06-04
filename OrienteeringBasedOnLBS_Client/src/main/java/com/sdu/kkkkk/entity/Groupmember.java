package com.sdu.kkkkk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by ASUS on 2018/6/4.
 */
@Entity
@Table(name = "groupmember")
@IdClass(GroupmemberKey.class)
public class Groupmember implements Serializable {
    public Groupmember(int gid, String sid) {
        this.gid = gid;
        this.sid = sid;
    }

    public Groupmember() {
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

    @Id
    private int gid;
    @Id
    private String sid;

}