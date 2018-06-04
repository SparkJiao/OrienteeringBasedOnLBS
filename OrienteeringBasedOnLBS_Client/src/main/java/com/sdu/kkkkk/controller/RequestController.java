package com.sdu.kkkkk.controller;

import com.sdu.kkkkk.Message;
import com.sdu.kkkkk.entity.Friend;
import com.sdu.kkkkk.entity.Request;
import com.sdu.kkkkk.repository.FriendRepository;
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
    @Autowired
    FriendRepository friendRepository;

    @RequestMapping("/findRequestByReceiver")
    public List<Request> findRequestByReceiver(String receiver){
        return requestRepository.findRequestByReceiver(receiver);
    }

    @RequestMapping("/findRequestBySender")
    public List<Request> findRequestBySender(String sender){
        return requestRepository.findRequestBySender(sender);
    }

    @RequestMapping("/saveRequest")
    public void saveRequest(String receiver,String sender){
        requestRepository.save(new Request(receiver,sender));
    }

    @RequestMapping("/agreeRequest")
    public void agreeRequest(int rid){
        requestRepository.agree(rid);
        Request request = requestRepository.findRequestByRid(rid);
        friendRepository.save(new Friend(request.getReceiver(),request.getSender()));
    }

    @RequestMapping("disagreeRequest")
    public void disagreeRequest(int rid){
        requestRepository.disagree(rid);
    }
}
