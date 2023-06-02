package com.mxt.login.service;

import com.mxt.login.dao.LoginDao;
import com.mxt.login.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层
 * 根据请求以及数据的结果，项目的业务功能的流程
 */
@Service
public class LoginService {

    @Autowired(required = false)
    LoginDao loginDao;

    public boolean login(String name,String password){

        //判断拿到的用户名和密码的格式是否复合规范（服务器端验证）

        //把密文根据算法转成明文

        //。。。。

        //找dao层跟数据库的数据匹配
        User user = loginDao.login(name,password);

        return user != null;

        //根据dao的返回结果继续下面的流程：用户的权限范围，详细信息，等级

        //返回结果
        //return true;//登录成功

    }

    public boolean delUser(int userId){
        return loginDao.delUser(userId);
    }

    public boolean insertUser(String name,String password){
        User user = new User(name,password);
        return loginDao.insertUser(user);
    }

    public List<User> getAllUsers(){
        return loginDao.getAllUsers();
    }

    public boolean updateUser(int userId, String name,String password){
        User user = new User(userId, name, password);
        return loginDao.updateUser(user);
    }
}
