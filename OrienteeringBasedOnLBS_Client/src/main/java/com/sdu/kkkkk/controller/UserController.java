package com.sdu.kkkkk.controller;

import com.sdu.kkkkk.entity.User;
import com.sdu.kkkkk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kkkkk on 2018/4/1.
 */
@RestController
@RequestMapping("/u")
public class UserController {
    private User curU;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/saveUser")
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @RequestMapping(value = "/findBySid")
    public User findBySid(String sid){
        return userRepository.findBySid(sid);
    }

    @RequestMapping(value = "/findByName")
    public User findByName(String name){
        return userRepository.findByName(name);
    }
}
