package com.sdu.kkkkk.models;

import com.sdu.kkkkk.entity.Wechat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2018/6/12.
 */
public class Members {
    private Wechat wechat;
    private List<Userinfo> memberInfos;

    public Members(Wechat wechat) {
        this.wechat = wechat;
        memberInfos = new ArrayList<>();
    }

    public Members(Wechat wechat, List<Userinfo> memberInfos) {
        this.wechat = wechat;
        this.memberInfos = memberInfos;
    }

    public Members() {
        wechat = null;
        memberInfos = new ArrayList<>();
    }

    public Wechat getWechat() {
        return wechat;
    }

    public void setWechat(Wechat wechat) {
        this.wechat = wechat;
    }

    public List<Userinfo> getMemberInfos() {
        return memberInfos;
    }

    public void setMemberInfos(List<Userinfo> memberInfos) {
        this.memberInfos = memberInfos;
    }
}
