package com.mxt.sql.dao;

import com.mxt.sql.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface sqlDao {
//    数字型
//    payload:1' 1"    -1 union select 1,database(),3,4--
    @Select("select * from user where username=${username} and password=${password}")
    public User sql0(@Param("username") String username, @Param("password") String password);
//    '闭合
//    payload:-1' union select 1,database(),3,4--
    @Select("select * from user where username='${username}' and password='${password}'")
    public User sql1(@Param("username") String username, @Param("password") String password);


//    payload:-1%' union select 1,database(),3,4--
//模糊查询
    @Select("Select * from user where username like '%${search}%'")
//    @Select("SELECT * FROM user where username=${search}")
    public List<User> sql2(@Param("search") String search);

//    ('闭合
//    payload:1') --    -1') union select 1,database(),3,4 -- s
    @Select("select * from user where username=('${username}') and password=('${password}')")
    public User sql3(@Param("username") String username, @Param("password") String password);

//    payload:-1) union select 1,database(),3,4--
    @Select("SElECT * FROM user where username in (${username})")
    public List<User> sql4(@Param("username") String username);

}
