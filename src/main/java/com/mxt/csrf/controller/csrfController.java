package com.mxt.csrf.controller;

import com.mxt.csrf.model.User;
import com.mxt.csrf.service.UsernameService;
import com.mxt.csrf.service.impl.UsernameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class csrfController {
    User user = new User();
    @Autowired
    private UsernameService userService;

    @GetMapping("/csrf")
    public String input() {
        return "index";
    }

    @RequestMapping(value="/csrf1",method = RequestMethod.POST)
    public String addUser1(User user1, Model model) {
        user.setUserid(user1.getUserid());
        user.setName(user1.getName());
        user.setPassword(user1.getPassword());
        userService.addUser(user);
        return "index";
    }

    @RequestMapping(value="/csrf2",method = RequestMethod.GET)
    public String addUser2(User user2, Model model) {
        user.setUserid(user2.getUserid());
        user.setName(user2.getName());
        user.setPassword(user2.getPassword());
        userService.addUser(user);
        return "index";
    }

}
