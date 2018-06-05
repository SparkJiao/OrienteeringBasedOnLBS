package com.sdu.kkkkk.controller;

import com.sdu.kkkkk.Message;
import com.sdu.kkkkk.entity.Groupnote;
import com.sdu.kkkkk.repository.GroupnoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ASUS on 2018/6/4.
 */
@RestController
public class GroupnoteController {

    @Autowired
    private GroupnoteRepository groupnoteRepository;

    @RequestMapping("/findGroupnotesByGidEquals")
    public List<Groupnote> findGroupnotesByGidEquals(int gid) {
        return groupnoteRepository.findGroupnotesByGidEquals(gid);
    }

    @RequestMapping("/addGroupnote")
    public Message<String> save(int gid, String sid, String category, String content) {
        groupnoteRepository.save(new Groupnote(gid, sid, category, content));
        return new Message<>(true,"success", "addGroupnote");
    }

    @RequestMapping("/cleanNotes")
    public Message<String> cleanNotes(){
        groupnoteRepository.deleteAll();
        return new Message<>(true,"success", "cleanNotes");
    }
}
