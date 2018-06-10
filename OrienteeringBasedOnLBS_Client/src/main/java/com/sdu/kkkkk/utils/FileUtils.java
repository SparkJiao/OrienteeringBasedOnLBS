package com.sdu.kkkkk.utils;

import com.sdu.kkkkk.models.Message;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by ASUS on 2018/6/9.
 */
public class FileUtils {

    /**
     *
     * @param file 文件
     * @param path 文件存放路径
     * @param fileName 源文件名
     * @return
     */
    public static Message<String> upload(MultipartFile file, String path, String fileName){

        // 生成新的文件名
        String newName = FileNameUtils.getFileName(fileName);
        String realPath = path + "/" + newName;

        //使用原文件名
        //String realPath = path + "/" + fileName;

        File dest = new File(realPath);

        //判断文件父目录是否存在
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }

        try {
            //保存文件
            file.transferTo(dest);
            return new Message<>(true,"success",newName);
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new Message<>(false,"Illegal State Exception!", null);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return new Message<>(false, "IO Exception", null);
        }

    }

}
