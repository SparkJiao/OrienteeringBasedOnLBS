package com.sdu.kkkkk.controller;

import com.sdu.kkkkk.entity.Trend;
import com.sdu.kkkkk.models.Message;
import com.sdu.kkkkk.repository.FriendRepository;
import com.sdu.kkkkk.repository.TrendRepository;
import com.sdu.kkkkk.utils.ContentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by kkkkk on 2018/4/1.
 */
@RestController
//@RequestMapping("/t")
public class TrendController {

    @Autowired
    private TrendRepository trendRepository;

    @Autowired
    private FriendRepository friendRepository;

    @RequestMapping("/addTrend")
    public Message<Trend> addTrend(String content, boolean hasVideo, List<MultipartFile> videos, boolean hasPhoto, List<MultipartFile> photos, String sid){
        String videoName = "";
        String photoName = "";
        if(hasVideo){
            //TODO if has video block here
        }
        if(hasPhoto){
            Message msg;
            for(int i=0;i<photos.size();i++){
                msg = ContentUtils.upload(photos.get(i));
                if(!msg.isFlag()) return msg;
                photoName += msg.getObj();
                if(i != photos.size() - 1) photoName += "*";
            }
        }
        Trend trend = new Trend(content,videoName,photoName,sid);
        trendRepository.save(trend);
        return new Message<Trend>(true,"success",trend);
    }

    @RequestMapping("/deleteTrend")
    public Message deleteTrend(int tid){
        trendRepository.deleteByTid(tid);
        return new Message(true,"success",null);
    }

    @RequestMapping("/findTrendsBySid")
    public List<Trend> findTrendsBySid(String sid){
        return trendRepository.findTrendsBySid(sid);
    }

    @RequestMapping("/findFriendsTrends")
    public List<Trend> findFriendsTrends(String sid){
        List<String> sids = findFriends(sid);
        return trendRepository.findTrendsBySidInOrderByTime(sids);
    }

    private List<String> findFriends(String sid){
        List<String> sidList1 = friendRepository.findSid_1BySid_2(sid);
        List<String> sidList2 = friendRepository.findSid_2BySid_1(sid);
        sidList1.addAll(sidList2);
        return sidList1;
    }
}
