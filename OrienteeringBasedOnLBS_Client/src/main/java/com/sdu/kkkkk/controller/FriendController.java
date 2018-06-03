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
    public List<Friend> findFriendsBySid(String sid) {
         return friendRepository.findBySid(sid);
    }

    @RequestMapping("/addFriend")
    public void saveFriend(String sid_1, String sid_2) {
        friendRepository.save(new Friend(sid_1, sid_2));
    }
}
