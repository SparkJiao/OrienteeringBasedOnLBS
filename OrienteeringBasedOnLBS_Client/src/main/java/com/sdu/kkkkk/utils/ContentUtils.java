package com.sdu.kkkkk.utils;

import com.sdu.kkkkk.models.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ASUS on 2018/6/10.
 */
public class ContentUtils {

    @Value("${web.upload-path}")
    private static String path;

    public static String returnContent(String category, Object content){
        String s = "";
        if(category == "1"){
            MultipartFile file = (MultipartFile)content;
            Message<String> msg = upload(file);
            s = msg.getObj();
        }else if(category == "2"){

        }else if(category == "0"){
            s = (String)content;
        }
        return s;
    }

    public static Message<String> upload(MultipartFile file){
        return FileUtils.upload(file, path ,file.getOriginalFilename());
    }
}
