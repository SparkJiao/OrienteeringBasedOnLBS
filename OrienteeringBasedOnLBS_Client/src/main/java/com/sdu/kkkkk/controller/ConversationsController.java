package com.sdu.kkkkk.controller;

import com.sdu.kkkkk.models.Message;
import com.sdu.kkkkk.entity.Conversations;
import com.sdu.kkkkk.repository.ConversationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kkkkk on 2018/5/7.
 */
@RestController
public class ConversationsController {

    @Autowired
    ConversationsRepository conversationsRepository;

    @RequestMapping("/findConversations")
    public List<Conversations> finConversations(String sender, String receiver, int coid) {
        return conversationsRepository.findConversationsBySenderAndReceiver(sender, receiver, coid);
    }

    @RequestMapping("/addConversations")
    public Message<Conversations> addConversations(String sender, String receiver, String category, String content) {
        conversationsRepository.save(new Conversations(sender, receiver, category, content));
        return new Message<Conversations>(true,"success",null);
    }
}
