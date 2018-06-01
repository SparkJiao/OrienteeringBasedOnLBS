package com.sdu.kkkkk.Application;

import java.io.Serializable;

/**
 * Created by ASUS on 2018/4/1.
 */
public class Message<T> implements Serializable{
    private boolean flag;
    private String msg;
    private T obj;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
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

    public Message(boolean flag,String msg, T t){
        this.flag = flag;
        this.msg = msg;
        this.obj = t;
    }
}
