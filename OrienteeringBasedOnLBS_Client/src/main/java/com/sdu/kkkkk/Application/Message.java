package com.sdu.kkkkk.Application;

import java.io.Serializable;

/**
 * Created by ASUS on 2018/4/1.
 */
public class Message<T> implements Serializable{
    private boolean ok;
    private String msg;
    private T obj;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
