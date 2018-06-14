package com.sdu.kkkkk.controller;

import com.sdu.kkkkk.entity.Comment;
import com.sdu.kkkkk.models.Message;
import com.sdu.kkkkk.repository.CommentRepository;
import com.sdu.kkkkk.repository.FriendRepository;
import com.sdu.kkkkk.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

/**
 * Created by kkkkk on 2018/4/1.
 */
@RestController
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private FriendRepository friendRepository;

    @Autowired
    private LikeRepository likeRepository;

    @RequestMapping("/addComment")
    public Message addComment(int tid, String content, String sid, String name, String rsid, String rname){
        //rsid = 0表示没有回复的对象
        Comment comment = new Comment(tid,content,sid,name,rsid,rname);
        commentRepository.save(comment);
        return new Message(true,"success",null);
    }

    @RequestMapping("/deleteComment")
    public Message deleteComment(int cid){
        commentRepository.deleteByCid(cid);
        return new Message(true,"success",null);
    }

    @RequestMapping("/findFriendsComments")
    public List<Comment> findFriendsComments(String sid, int tid){
        List<String> sids = findFriends(sid);
        return commentRepository.findCommentsByTidAndSidInAndRsidInOrderByTime(tid,sids, sids);
    }

    public List<String> findFriends(String sid){
        List<String> sidList1 = friendRepository.findSid_1BySid_2(sid);
        List<String> sidList2 = friendRepository.findSid_2BySid_1(sid);
        sidList1.addAll(sidList2);
        return sidList1;
    }

    @RequestMapping("/updateComments")
    public List<Comment> updateComments(String sid, Date time){
        List<Integer> tids = likeRepository.findTidsBySid(sid);
        List<Integer> tidss = commentRepository.findTidsBySid(sid);
        tids.addAll(tidss);
        List<String> sids = findFriends(sid);
        return commentRepository.findCommentsByTidInAndSidInAndRsidInAndTimeAfterOrderByTime(tids,sids, sids, time);
    }
}
