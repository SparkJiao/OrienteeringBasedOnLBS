package com.sdu.kkkkk.controller;

import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.sdu.kkkkk.Message;
import com.sdu.kkkkk.entity.Friend;
import com.sdu.kkkkk.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by KKKKK on 2018/5/7.
 */
@RestController
public class FriendController {

    @Autowired
    FriendRepository friendRepository;

    @RequestMapping("/findFriendsBySid")
    public List<String> findFriendsBySid(String sid) {
         List<String> sidList1 = friendRepository.findSid_1BySid_2(sid);
         List<String> sidList2 = friendRepository.findSid_2BySid_1(sid);
         sidList1.addAll(sidList2);
         return sidList1;
    }

    /*@RequestMapping("/addFriend")
    public void saveFriend(String sid_1, String sid_2) {
        friendRepository.save(new Friend(sid_1, sid_2));
    }*/

    @RequestMapping("/deleteFriend")
    public void deleteFriend(String sid_1, String sid_2){
        friendRepository.deleteFriendBySid_1AndSid_2(sid_1, sid_2);
    }
}
