package com.mxt.sql.service;

import com.mxt.sql.dao.sqlDao;
import com.mxt.sql.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class sqlService {

    @Autowired(required = false)
    sqlDao sqlDao;

    public User sql0(String  username,String password){

        User user = sqlDao.sql0(username,password);
        return user ;
    }

    public User sql1(String  username,String password){

        User user = sqlDao.sql1(username,password);
        return user ;
    }

    public List<User> sql2(String search){
        return sqlDao.sql2(search);
    }

    public User sql3(String  username,String password){

        User user = sqlDao.sql3(username,password);
        return user ;
    }

    public List<User> sql4(String username){
        return sqlDao.sql4(username);
    }
}
