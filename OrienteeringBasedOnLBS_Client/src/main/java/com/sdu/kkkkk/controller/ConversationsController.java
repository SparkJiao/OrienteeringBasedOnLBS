package com.sdu.kkkkk.controller;

import com.sdu.kkkkk.models.Message;
import com.sdu.kkkkk.entity.Conversations;
import com.sdu.kkkkk.repository.ConversationsRepository;
import com.sdu.kkkkk.utils.ContentUtils;
import com.sdu.kkkkk.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.AbstractDocument;
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
    public Message<Conversations> addConversations(String sender, String receiver, String category, Object content) {
        String s = ContentUtils.returnContent(category, content);
        conversationsRepository.save(new Conversations(sender, receiver, category, s));
        return new Message<Conversations>(true,"success",null);
    }
}
