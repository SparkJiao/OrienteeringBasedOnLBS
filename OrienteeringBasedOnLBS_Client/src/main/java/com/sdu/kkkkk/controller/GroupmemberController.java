package com.sdu.kkkkk.controller;

import com.sdu.kkkkk.models.Members;
import com.sdu.kkkkk.models.Message;
import com.sdu.kkkkk.entity.Wechat;
import com.sdu.kkkkk.entity.Groupmember;
import com.sdu.kkkkk.entity.GroupmemberKey;
import com.sdu.kkkkk.entity.User;
import com.sdu.kkkkk.models.Userinfo;
import com.sdu.kkkkk.repository.UserRepository;
import com.sdu.kkkkk.repository.WechatRepository;
import com.sdu.kkkkk.repository.GroupmemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kkkkk on 2018/6/4.
 */
@RestController
public class GroupmemberController {

    @Autowired
    private GroupmemberRepository groupmemberRepository;

    @Autowired
    private WechatRepository wechatRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/findGroupsBySid")
    public List<Members> findGroupsBySid(String sid){
        List<Integer> gidsList = groupmemberRepository.findGidsBySid(sid);
        List<Members> wechats = new ArrayList<>();
        for(int i=0;i<gidsList.size();i++){
            int gid  = gidsList.get(i);
            System.out.println(gid);
            //wechatList.add(wechatRepository.findWechatByGid(gidsList.get(i)));
            Members tmp = new Members(wechatRepository.findWechatByGid(gid));
            List<Userinfo> memberInfos = tmp.getMemberInfos();
            List<String> sids = groupmemberRepository.findSidsByGid(gid);
            for(int j=0;j<sids.size();j++){
                User user = userRepository.findBySid(sids.get(j));
                Userinfo userinfo = new Userinfo(user.getSid(),user.getImage(),user.getName());
                memberInfos.add(userinfo);
            }
            wechats.add(tmp);
        }
        return wechats;
    }

    @RequestMapping("/invite")
    public Message<String> invite(String sid, int gid){
        groupmemberRepository.save(new Groupmember(gid,sid));
        return new Message<>(true,"success","invite");
    }

    @RequestMapping("/exitGroup")
    public Message<String> exitGroup(String sid,int gid){
        groupmemberRepository.deleteById(new GroupmemberKey(gid, sid));
        return new Message<>(true, "success", "exit");
    }

    @RequestMapping("/cancelGroup")
    public Message<String> cancelGroup(int gid){
        groupmemberRepository.deleteGroupmembersByGid(gid);
        return new Message<>(true, "success", "cancel");
    }
}
