package com.boottest.boot.controller;

import com.boottest.boot.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class HelloController {
    private static Map<String,Object> result;
    @RequestMapping("/")
    public String getHello(){
       return "hello";
    }
    @RequestMapping("/test")
    public Map<String,String> testRest(){
        Map<String,String> map = new HashMap();
        map.put("name","lhy");
        return map;
    }

    @GetMapping("/userTest")
    public Object userTest(Integer age,String name,String phone){
        return new User(name,age,new Date(),phone);
    }

    @GetMapping("/toHello")
    public String toHello(){
        return "hello";
    }
    @GetMapping("/uploadForm")
    public String uploadForm(){
        return "upload";
    }
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("head_img")MultipartFile file, HttpServletRequest request){
        String name = request.getParameter("name");
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File("d://"+fileName);
        try{
            file.transferTo(dest);
            return fileName;
        }catch (Exception e){
            e.printStackTrace();
            return "上传失败";
        }

    }
}
