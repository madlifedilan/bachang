package com.mxt.xss.controller;


import com.mxt.xss.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class XssController {

    @GetMapping("/home")
    public String index() {
        return "index";
    }

    @GetMapping("/xss1")
    @ResponseBody
    public String xss1(String xss){
        return xss;
    }

    @PostMapping("/xss2")
    @ResponseBody
    public String xss2(String xss){
        return xss;
    }

    @PostMapping("/xss3")
    @ResponseBody
    public String xss3(String xss){
        return xss;
    }

}
