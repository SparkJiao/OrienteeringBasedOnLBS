package com.sdu.kkkkk.controller;

import com.sdu.kkkkk.entity.Wechat;
import com.sdu.kkkkk.models.Members;
import com.sdu.kkkkk.models.Message;
import com.sdu.kkkkk.entity.Groupmember;
import com.sdu.kkkkk.entity.User;
import com.sdu.kkkkk.models.Userinfo;
import com.sdu.kkkkk.repository.UserRepository;
import com.sdu.kkkkk.repository.WechatRepository;
import com.sdu.kkkkk.repository.GroupmemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kkkkk on 2018/6/4.
 */
@RestController
public class WechatController {

    @Autowired
    private WechatRepository wechatRepository;
    @Autowired
    private GroupmemberRepository groupmemberRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/createGroup")
    public Wechat createGroup(String name, String members){
        System.out.println(members);
        String[] tmp = members.split(",");
        Wechat wechat = wechatRepository.save(new Wechat(name, tmp[0]));
        int gid = wechat.getGid();
        for(int i=0;i<tmp.length;i++){
            System.out.println(tmp[i]);
            groupmemberRepository.save(new Groupmember(gid, tmp[i]));
        }
        return wechat;
    }

    @RequestMapping("/findGroupByGid")
    public Message<Members> findGroupByGid(int gid) {
        Wechat wechat = wechatRepository.findWechatByGid(gid);
        if (wechat == null) return new Message<>(false, "no such wechat exist", null);
        else{
            Members members = new Members(wechat);
            List<Userinfo> memberInfos =  members.getMemberInfos();
            List<String> sids = groupmemberRepository.findSidsByGid(gid);
            for(int i=0;i<sids.size();i++){
                String sid = sids.get(i);
                User user = userRepository.findBySid(sid);
                Userinfo userinfo = new Userinfo(user.getSid(),user.getImage(), user.getName());
                memberInfos.add(userinfo);
            }
            return new Message<>(true, "success", members);
        }
        //return new Message<>(true, "success", wechat);
    }
}
