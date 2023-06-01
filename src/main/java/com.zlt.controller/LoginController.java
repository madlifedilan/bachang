package com.zlt.controller;

import com.zlt.entity.User;
import com.zlt.service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 控制层：该层的代码是能够通过url地址被访问的：http://127.0.0.1:8080/demo1/loginController/login
 * 1. 接收前端的请求，请求携带的数据
 * 2. 把请求以及数据交给servic来处理
 * 3. 根据service的返回结果，给前端返回信息
 */
@RestController
public class LoginController {

    @Autowired(required = false)
    LoginService loginService;

    /**
     *
     * @param name:前端界面所输入的用户名信息
     * @param password：前端界面所输入的密码信息
     * @return  前端界面能够接收到的信息
     */
    @RequestMapping(value="login",method = RequestMethod.POST)
    @ApiOperation("登录")
    String login(String name,String password){

        boolean flag = loginService.login(name,password);

        String result = "";
        if(flag){
            result = "登录成功";
        }else{
            result = "登录失败";
        }

        return result;
    }

    @RequestMapping(value = "delUser", method = RequestMethod.GET)
    @ApiOperation("删除用户")
    boolean delUser(int userId){
        return loginService.delUser(userId);
    }

    @RequestMapping(value = "insertUser", method = RequestMethod.GET)
    @ApiOperation("添加用户")
    boolean insertUser(String name,String password){
        return loginService.insertUser(name, password);
    }

    @RequestMapping(value = "getAllUsers", method = RequestMethod.GET)
    @ApiOperation("显示全部用户")
    List<User> getAllUsers(){
        return loginService.getAllUsers();
    }

    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    @ApiOperation("更新用户信息")
    boolean updateUser(int userId, String name,String password){
        return loginService.updateUser(userId, name, password);
    }
}
