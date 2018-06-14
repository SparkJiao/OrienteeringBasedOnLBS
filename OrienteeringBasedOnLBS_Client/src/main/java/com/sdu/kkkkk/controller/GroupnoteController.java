package com.sdu.kkkkk.controller;

import com.sdu.kkkkk.models.Message;
import com.sdu.kkkkk.entity.Groupnote;
import com.sdu.kkkkk.repository.GroupnoteRepository;
import com.sdu.kkkkk.utils.ContentUtils;
import com.sdu.kkkkk.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by kkkkk on 2018/6/4.
 */
@RestController
public class GroupnoteController {

    @Autowired
    private GroupnoteRepository groupnoteRepository;

    @RequestMapping("/findGroupnotesByGidEquals")
    public List<Groupnote> findGroupnotesByGidEquals(int gid, int gnid) {
        return groupnoteRepository.findGroupnotesByGidEqualsAndGnidGreaterThanOrderByTime(gid, gnid);
    }

    @RequestMapping("/addGroupnote")
    public Message<String> save(int gid, String sid, String category, MultipartFile audio, MultipartFile photo, String content) {
        String s = ContentUtils.returnContent(category, audio, photo, content);
        groupnoteRepository.save(new Groupnote(gid, sid, category, s));
        return new Message<>(true, "success", "addGroupnote");
    }

    //@RequestMapping("/cleanNotes")
    public Message<String> cleanNotes() {
        groupnoteRepository.deleteAll();
        return new Message<>(true, "success", "cleanNotes");
    }
}
