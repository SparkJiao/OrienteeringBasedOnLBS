package com.sdu.kkkkk.controller;

import com.sdu.kkkkk.models.Message;
import com.sdu.kkkkk.utils.FileUtils;
import com.sun.jndi.toolkit.url.Uri;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by kkkkk on 2018/6/9.
 */
@RestController
public class FileController {

    private final ResourceLoader resourceLoader;

    @Autowired
    public FileController(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Value("${web.upload-path}")
    private String path;

    /**
     * 跳转到文件上传页面
     * @return
     */
    /*@RequestMapping("test")
    public String toUpload(){
        return "test";
    }*/

    /**
     *
     * @param file 要上传的文件
     * @return
     */
    @RequestMapping("/fileUpload")
    public Message<String> upload(@RequestParam("fileName") MultipartFile file){

        // 要上传的目标文件存放路径
        String localPath = path;

        return FileUtils.upload(file,localPath,file.getOriginalFilename());
    }

    /**
     * 显示单张图片
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/show", produces = MediaType.IMAGE_PNG_VALUE)
    @ResponseBody
    public ResponseEntity showPhotos(String fileName){

        try {
            // 由于是读取本机的文件，file是一定要加上的， path是在application配置文件中的路径
            ResponseEntity re = ResponseEntity.ok(resourceLoader.getResource("file:" + path + "/" + fileName));
            return re;
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

//        String realPath = path + "/" + fileName;
//        File file = new File(realPath);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType);

    }

}