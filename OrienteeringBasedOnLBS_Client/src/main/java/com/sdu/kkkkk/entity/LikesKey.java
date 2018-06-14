package com.sdu.kkkkk.entity;

import java.io.Serializable;

/**
 * Created by ASUS on 2018/6/10.
 */
public class LikesKey implements Serializable{

    private int tid;
    private String  sid;

    public LikesKey(int tid, String sid) {
        this.tid = tid;
        this.sid = sid;
    }

    public LikesKey() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LikesKey likesKey = (LikesKey) o;

        if (getTid() != likesKey.getTid()) return false;
        return getSid() != null ? getSid().equals(likesKey.getSid()) : likesKey.getSid() == null;
    }

    @Override
    public int hashCode() {
        int result = getTid();
        result = 31 * result + (getSid() != null ? getSid().hashCode() : 0);
        return result;
    }
}
