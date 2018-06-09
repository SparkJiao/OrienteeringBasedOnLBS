package com.sdu.kkkkk.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kkkkk on 2018/6/3.
 */
@Entity
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;
    private String receiver;
    private String sender;
    private Date time;
    //default:0:wait 1:agree -1:disagree
    private int state;
    private String message;

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Request(String receiver, String sender, String message){
        this.receiver = receiver;
        this.sender = sender;
        this.message = message;
        this.state = 0;
    }
}
