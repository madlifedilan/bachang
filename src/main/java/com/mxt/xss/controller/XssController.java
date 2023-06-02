package com.mxt.xss.controller;


import com.mxt.xss.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class XssController {

    @GetMapping("/home")
    public String index() {
        return "index";
    }

    @PostMapping ("/xssoutput")
    @ResponseBody
    public String outputmessage(@RequestParam("name") String name, Model model){
        Person person = new Person(name);
        model.addAttribute("myperson",person);
        return name;
    }

}
