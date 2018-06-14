package com.sdu.kkkkk.utils;

import com.sdu.kkkkk.models.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ASUS on 2018/6/10.
 */
public class ContentUtils {

    private static String path = "C:/Users/ASUS/Desktop/img";

    public static String transAudio(MultipartFile audio){
        String s = "";
        return s;
    }

    public static String transPhoto(MultipartFile photo){
        Message<String> msg = upload(photo);
        String s = msg.getObj();
        return s;
    }

    public static String transMedia(MultipartFile media){
        Message<String> msg = upload(media);
        String s = msg.getObj();
        return s;
    }

    public static String returnContent(String category, MultipartFile audio, MultipartFile photo, String content){
        String s = "";
        if(category.equals("0"))
            s = content;
        else if(category.equals("1"))
            s = ContentUtils.transPhoto(photo);
        else if(category.equals("2"))
            s = ContentUtils.transAudio(audio);
        return s;
    }

    public static Message<String> upload(MultipartFile file){
        return FileUtils.upload(file, path,file.getOriginalFilename());
    }
}
