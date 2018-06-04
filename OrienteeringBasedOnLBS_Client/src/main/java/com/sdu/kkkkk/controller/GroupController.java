package com.sdu.kkkkk.controller;

import com.sdu.kkkkk.Message;
import com.sdu.kkkkk.entity.Group;
import com.sdu.kkkkk.entity.Groupmember;
import com.sdu.kkkkk.repository.GroupRepository;
import com.sdu.kkkkk.repository.GroupmemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by ASUS on 2018/6/4.
 */
@RestController
public class GroupController {

    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private GroupmemberRepository groupmemberRepository;

    @RequestMapping("/createGroup")
    public Group createGroup(String name, List<String> members, String image) {
        Group group = groupRepository.save(new Group(name, members.get(0), image));
        int gid = group.getGid();
        for(int i=1;i<members.size();i++){
            groupmemberRepository.save(new Groupmember(gid,members.get(i)));
        }
        return group;
    }

    @RequestMapping("/findGroupByGid")
    public Message<Group> findGroupByGid(int gid) {
        Group group = groupRepository.findGroupByGid(gid);
        if (group == null) return new Message<>(false, "no such group exist", null);
        else return new Message<>(true, "success", group);
    }
}
