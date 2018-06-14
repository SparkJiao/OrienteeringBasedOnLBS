package com.sdu.kkkkk.controller;

import com.sdu.kkkkk.models.Location;
import com.sdu.kkkkk.models.Message;
import com.sdu.kkkkk.entity.Friend;
import com.sdu.kkkkk.entity.User;
import com.sdu.kkkkk.models.Userinfo;
import com.sdu.kkkkk.repository.FriendRepository;
import com.sdu.kkkkk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kkkkk on 2018/5/7.
 */
@RestController
public class FriendController {

    @Autowired
    private FriendRepository friendRepository;
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/findFriendsBySid")
    public List<String> findFriendsBySid(String sid) {
         List<String> sidList1 = friendRepository.findSid_1BySid_2(sid);
         List<String> sidList2 = friendRepository.findSid_2BySid_1(sid);
         sidList1.addAll(sidList2);
         return sidList1;
    }

    @RequestMapping("/addFriend")
    public void saveFriend(String sid_1, String sid_2) {
        friendRepository.save(new Friend(sid_1, sid_2));
    }

    @RequestMapping("/deleteFriend")
    public Message<Friend> deleteFriend(String sid_1, String sid_2){
        Friend f =  friendRepository.deleteFriendBySid_1AndSid_2(sid_1, sid_2);
        return new Message<>(true,"success", f);
    }

    @RequestMapping("/getFriendsLocations")
    public List<Location> getFriendsLocations(String sid){
        List<String> sids = findFriendsBySid(sid);
        List<Location> locations = new ArrayList<>();
        for(int i=0;i<sids.size();i++){
            User user = userRepository.findBySid(sids.get(i));
            locations.add(new Location(user.getSid(), user.getImage(),user.getLongitude(),user.getLatitude()));
        }
        return locations;
    }

    @RequestMapping("/getFriendsUserinfo")
    public List<Userinfo> getFriendsUserinfo(String sid){
        List<String> sids = findFriendsBySid(sid);
        List<Userinfo> userinfos = new ArrayList<>();
        for(int i=0;i<sids.size();i++){
            User user = userRepository.findBySid(sids.get(i));
            userinfos.add(new Userinfo(user.getSid(),user.getImage(),user.getName()));
        }
        return userinfos;
    }
}
