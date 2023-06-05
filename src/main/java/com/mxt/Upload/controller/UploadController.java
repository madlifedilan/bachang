package com.mxt.Upload.controller;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

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
        result.put("filename", filename);
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
        result.put("filename", filename);
        if (outfile.exists()) {
            outfile.delete();
        }
        return result;
    }

    @RequestMapping(value = "/upload4", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, String> upload4(MultipartFile file) {
        String filename = file.getOriginalFilename();
        // 检查文件名是否存在黑名单中字符
        if (hasBlacklistedExtension(filename)) {
            filename = removeBlacklistedExtension(filename)+".txt";
        }
        // 文件保存路径
        File outfile = new File(this.path + filename);
        try {
            file.transferTo(outfile);
        } catch (IOException e){
            e.printStackTrace();
        }

        Map<String, String> result = new HashMap<>();

        result.put("status", "success");
        result.put("filename", filename);
        if (outfile.exists()) {
            outfile.delete();
        }

        return result;
    }

    // 检查文件名是否存在黑名单中字符
    private boolean hasBlacklistedExtension(String filename) {
        Set<String> blacklist = new HashSet<>(Arrays.asList("jsp", "php", "exe", "dll", "vxd", "html"));
        String extension = FilenameUtils.getExtension(filename);
        return blacklist.contains(extension.toLowerCase());
    }

    // 将文件名中的黑名单字符替换为空字符串
    private String removeBlacklistedExtension(String filename) {
        String extension = FilenameUtils.getExtension(filename);
        if (hasBlacklistedExtension(filename)) {
            return FilenameUtils.removeExtension(filename) + extension.replaceAll("[^.\\s]+", "");
        } else {
            return filename;
        }
    }
}

