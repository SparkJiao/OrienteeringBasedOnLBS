package com.sdu.kkkkk.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by KKKKK on 2018/5/7.
 */
@Entity
@Table(name="friend")
@IdClass(FriendKey.class)
public class Friend implements Serializable{

    @Id
    private String sid_1;
    @Id
    private String sid_2;

    public Friend(String sid_1, String sid_2) {
        this.sid_1 = sid_1;
        this.sid_2 = sid_2;
    }

    public Friend(){}

    public String getSid_1() {
        return sid_1;
    }

    public String getSid_2() {
        return sid_2;
    }

    public void setSid_1(String sid_1) {
        this.sid_1 = sid_1;
    }
}
