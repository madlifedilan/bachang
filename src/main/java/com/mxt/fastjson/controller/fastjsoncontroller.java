package com.mxt.fastjson.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mxt.fastjson.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class fastjsoncontroller {

//    @GetMapping("/fastjson")
//    public String input(){
//        return "fastjson/fastjson";
//    }

    @RequestMapping (value="/fastjson",method=RequestMethod.POST)
    @ResponseBody
    public String fastjson1(@RequestBody String jsonData) {
        User user = new User();
        JSONObject jsonObject = JSON.parseObject(jsonData);
        user.setAge(jsonObject.getString("age"));
        user.setUsername(jsonObject.getString("username"));
        String result = "Name: " + user.getUsername() + " ; " + "Age: " + user.getAge();
        return result;
    }

//    @RequestMapping ("/fastjson2")
//    public String fastjson2( Model model) {
//        model.addAttribute("result",user);
//        return "fastjson/fastjsonoutput";
//    }
}