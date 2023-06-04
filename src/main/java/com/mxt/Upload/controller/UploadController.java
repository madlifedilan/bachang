package com.mxt.Upload.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {
    String path="C:\\Users\\home\\Desktop\\bachang\\src\\main\\java\\com\\mxt\\Upload\\file";

    @RequestMapping(value = "/upload1", method=RequestMethod.POST)
    @ResponseBody
    public Map<String,String> upload1(MultipartFile file){
        //获取文件名
        String filename = file.getOriginalFilename();
        //文件保存路径
        File outfile = new File(this.path + filename);
        try {
            file.transferTo(outfile);
        }catch (IOException e){
            e.printStackTrace();
        }
        Map<String ,String > result =new HashMap<>();
        result.put("status","success");
        if (outfile.exists()) {
            outfile.delete();
        }
        return result;
    }

    @RequestMapping(value = "/upload2", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, String> upload2(MultipartFile file){
        String filename = file.getOriginalFilename();
        //文件保存路径
        File outfile = new File(this.path + filename);
        try {
            file.transferTo(outfile);
        }catch (IOException e){
            e.printStackTrace();
        }
        Map<String ,String > result =new HashMap<>();
        result.put("status","success");
        if (outfile.exists()) {
            outfile.delete();
        }
        return result;
    }
}

