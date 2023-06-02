package com.mxt.csrf.service.impl;

import com.mxt.csrf.model.User;
import com.mxt.csrf.mapper.UsernameMapper;
import com.mxt.csrf.service.UsernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsernameServiceImpl implements UsernameService {
    @Autowired
    private UsernameMapper usernameMapper;

    @Override
    public void addUser(User user) {
        usernameMapper.addUser(user);
    }
}
