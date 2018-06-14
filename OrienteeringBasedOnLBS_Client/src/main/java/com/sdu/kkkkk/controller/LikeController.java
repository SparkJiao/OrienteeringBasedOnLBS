package com.sdu.kkkkk.controller;

import com.sdu.kkkkk.entity.Like;
import com.sdu.kkkkk.models.Message;
import com.sdu.kkkkk.repository.CommentRepository;
import com.sdu.kkkkk.repository.FriendRepository;
import com.sdu.kkkkk.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Created by kkkkk on 2018/6/10.
 */
@RestController
public class LikeController {

    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private FriendRepository friendRepository;
    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping("/addLike")
    public Message addLike(int tid, String sid, String name, String image){
        likeRepository.save(new Like(tid,sid, name, image));
        return new Message(true,"success", null);
    }

    @RequestMapping("/cancelLike")
    public Message cancelLike(int tid, String sid){
        likeRepository.deleteLikeByTidAndSid(tid, sid);
        return new Message(true,"success", null);
    }

    @RequestMapping("/findFriendsLikes")
    public List<Like> findFriendsLikes(int tid, String sid){
        List<String> sids = findFriends(sid);
        return likeRepository.findLikesByTidAndSidInOrderByTime(tid, sids);
    }

    private List<String> findFriends(String sid){
        List<String> sidList1 = friendRepository.findSid_1BySid_2(sid);
        List<String> sidList2 = friendRepository.findSid_2BySid_1(sid);
        sidList1.addAll(sidList2);
        return sidList1;
    }

    @RequestMapping("/updateLikes")
    public List<Like> updateLikes(String sid, Date time){
        List<Integer> tids = likeRepository.findTidsBySid(sid);
        List<Integer> tidss = commentRepository.findTidsBySid(sid);
        tids.addAll(tidss);
        List<String> sids = findFriends(sid);
        return likeRepository.findLikesByTidInAndSidInAndTimeAfterOrderByTime(tids, sids, time);
    }
}
