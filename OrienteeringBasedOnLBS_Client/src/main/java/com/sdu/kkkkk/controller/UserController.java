package com.sdu.kkkkk.controller;

import com.sdu.kkkkk.models.Location;
import com.sdu.kkkkk.models.MD5;
import com.sdu.kkkkk.models.Message;
import com.sdu.kkkkk.entity.User;
import com.sdu.kkkkk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kkkkk on 2018/4/1.
 */
@RestController
//@RequestMapping("/u")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String index(){
        return "Hello world！";
    }

    @RequestMapping(value = "/saveUser")
    public User saveUser(String sid,String password, String name){
        password = (new MD5()).md5(password, sid);
        return userRepository.save(new User(sid, password, name));
    }

    @RequestMapping(value = "/findUserBySid")
    public Message<User> findBySid(String sid){
        User user = userRepository.findBySid(sid);
        if(user != null)
            return new Message<User>(true,"success",user);
        else
            return new Message<User>(false,"failure", null);
    }

    @RequestMapping(value = "/getLongitudeAndLatitude")
    public Message<Location> getLongtitudeAndLatitude(String sid){
        User user = userRepository.findBySid(sid);
        return new Message<>(true,"success", new Location(user.getImage(), user.getLongitude(),user.getLatitude()));
    }

    @RequestMapping(value = "/updateLocation")
    public Message<User> updateLocation(String sid, String longitude, String latitude){
        System.out.println(sid + " " +  longitude + " " + latitude);
        User user = userRepository.findBySid(sid);
        if(user != null) {
            userRepository.updateLongitudeAndLatitudeBySid(sid, longitude, latitude);
            return new Message<User>(true,"success", user);
        }else
            return new Message<User>(false,"failure", null);
    }

    @RequestMapping(value = "/login")
    public Message<User> logIn(@Param("sid")String sid, @Param("password")String password){
        System.out.println(sid + " " + password);
        User user = userRepository.findBySid(sid);
        if(user!=null){
            if(user.getPassword().equals(password)){
                return new Message<>(true,"success",user);
            }else
                return new Message<>(false,"wrong password",null);
        }else{
            return new Message<>(false,"no such student", null);
        }
    }
}
