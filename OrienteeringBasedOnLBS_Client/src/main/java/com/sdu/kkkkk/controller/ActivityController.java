package com.sdu.kkkkk.controller;

import com.sdu.kkkkk.entity.Activity;
import com.sdu.kkkkk.models.Message;
import com.sdu.kkkkk.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kkkkk on 2018/4/1.
 */
@RestController
//@RequestMapping("/a")
public class ActivityController {

    @Autowired
    private ActivityRepository activityRepository;

    @RequestMapping("/addActivity")
    public Message addActivity(String splace, String epalce, String sid){
        activityRepository.save(new Activity(splace, epalce, sid));
        return new Message(true, "success", null);
    }

    @RequestMapping("/findActivities")
    public List<Activity> findActivities(String sid){
        return activityRepository.findActivitiesBySidEquals(sid);
    }
}
