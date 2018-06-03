package com.sdu.kkkkk.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by KKKKK on 2018/5/7.
 */

@Entity
@Table(name = "conversations")
public class Conversations {

    public int getCoid() {
        return coid;
    }

    public void setCoid(int coid) {
        this.coid = coid;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int coid;
    private String sender;
    private String receiver;
    private Date time;
    private String category;
    private String content;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    private int state;
    // 0 未读 1 已读

    public Conversations(String sender, String receiver, String category, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.category = category;
        this.content = content;
        this.state = 0;
    }

    public Conversations(){}

}
