package com.sdu.kkkkk.controller;

import com.sdu.kkkkk.models.Message;
import com.sdu.kkkkk.entity.Friend;
import com.sdu.kkkkk.entity.Request;
import com.sdu.kkkkk.repository.FriendRepository;
import com.sdu.kkkkk.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kkkkk on 2018/6/3.
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

    @RequestMapping("findRequestByRid")
    public Message<Request> findRequestByRid(int rid){
        Request request = requestRepository.findRequestByRid(rid);
        if(request == null)
            return new Message<>(false,"faliure", null);
        else
            return new Message<>(true,"success",request);
    }

    @RequestMapping("/saveRequest")
    public Message<String> saveRequest(String receiver,String sender, String message){
        requestRepository.save(new Request(receiver,sender, message));
        return new Message<>(true,"success", "saveRequest");
    }

    @RequestMapping("/agreeRequest")
    public Message<String> agreeRequest(int rid){
        requestRepository.agree(rid);
        Request request = requestRepository.findRequestByRid(rid);
        friendRepository.save(new Friend(request.getReceiver(),request.getSender()));
        return new Message<>(true,"success","agree");
    }

    @RequestMapping("/disagreeRequest")
    public Message disagreeRequest(int rid){
        requestRepository.disagree(rid);
        return new Message<>(true,"success",null);
    }
}
