package com.mxt.sql.controller;

import com.mxt.sql.entity.User;
import com.mxt.sql.service.sqlService;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class sqlController {

    @Autowired(required = false)
    sqlService sqlService;

    @RequestMapping(value="/sql0",method = RequestMethod.POST)
    @ApiOperation("sql0")
    public String sql0(String username,String password){
        User user = sqlService.sql0(username,password);
        String result = "";
        if (user!= null){
            result="name"+user.getUsername()+":"+"score"+user.getScore();
        }else {
            result="fail";
        }

        return result;
    }

    @RequestMapping(value="/sql1",method = RequestMethod.POST)
    @ApiOperation("sql1")
    public String sql1(String username,String password){
        User user = sqlService.sql1(username,password);
        String result = "";
        if (user!= null){
            result="name"+user.getUsername()+":"+"score"+user.getScore();
        }else {
            result="fail";
        }

        return result;
    }

    @RequestMapping(value="/sql2",method = RequestMethod.POST)
    @ApiOperation("sql2")
    String sql2(String search){
        List<User> userList = sqlService.sql2(search);
        String result="";
        for(User user:userList){
            result = result+user.getUsername()+"用户"+"\n";
        }
        return result;

    }

    @RequestMapping(value="/sql3",method = RequestMethod.POST)
    @ApiOperation("sql3")
    public String sql3(String username,String password){
        User user = sqlService.sql3(username,password);
        String result = "";
        if (user!= null){
            result="name"+user.getUsername()+":"+"score"+user.getScore();
        }else {
            result="fail";
        }

        return result;
    }

    @RequestMapping(value="/sql4",method = RequestMethod.POST)
    @ApiOperation("sql4")
    String sql4(String username){
        List<User> userList = sqlService.sql4(username);
        String result="";
        for(User user:userList){
            result = result+user.getUsername()+"用户"+"\n";
        }
        return result;
    }
}
