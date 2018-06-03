package com.sdu.kkkkk.controller;

import com.sdu.kkkkk.Message;
import com.sdu.kkkkk.entity.Request;
import com.sdu.kkkkk.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ASUS on 2018/6/3.
 */
@RestController
public class RequestController {

    @Autowired
    RequestRepository requestRepository;

    @RequestMapping("/findRequestByReceiver")
    public Message<List<Request>> findRequestByReceiver(String receiver){
        Message<List<Request>> message = new Message<>(true,"success",requestRepository.findRequestByReceiver(receiver));
        System.out.println(message);
        return message;
    }

    @RequestMapping("/findRequestBySender")
    public Message<List<Request>> findRequesetBySender(String sender){
        Message<List<Request>> message = new Message<>(true,"success",requestRepository.findRequestBySender(sender));
        System.out.println(message);
        return message;
    }

    @RequestMapping("/saveRequest")
    public void saveRequest(String receiver,String sender){
        requestRepository.save(new Request(receiver,sender));
    }

    @RequestMapping("/agreeRequest")
    public void agreeRequest(int rid){
        requestRepository.agree(rid);
        //前端请求/addFriend
    }

    @RequestMapping("disagreeRequest")
    public void disagreeRequest(int rid){
        requestRepository.disagree(rid);
    }
}
