package com.sdu.kkkkk.controller;

import com.sdu.kkkkk.entity.Group;
import com.sdu.kkkkk.entity.Groupmember;
import com.sdu.kkkkk.repository.GroupRepository;
import com.sdu.kkkkk.repository.GroupmemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2018/6/4.
 */
@RestController
public class GroupmemberController {

    @Autowired
    private GroupmemberRepository groupmemberRepository;

    @Autowired
    private GroupRepository groupRepository;

    @RequestMapping("/findGroupsBySid")
    public List<Group> findGroupsBySid(String sid){
        List<Integer> gidsList = groupmemberRepository.findGidsBySid(sid);
        List<Group> groupList = new ArrayList<>();
        for(int i=0;i<gidsList.size();i++){
            groupList.add(groupRepository.findGroupByGid(gidsList.get(i)));
        }
        return groupList;
    }
}
