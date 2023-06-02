package com.mxt.login.dao;

import com.mxt.login.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 持久层：与持久化相关的层，内存的数据是瞬时，数据库/文件系统的数据是持久的
 * DAO:data access object，数据访问对象
 * 与持久化数据的数据库/文件系统对接的类
 * 代码端——持久化端
 *  把代码端的执行结果数据放入持久化端，下次再用
 *  把持久化端的数据读到代码端，业务验证
 *
 * 通过loginDao类的方法，能够访问到数据库中的与登录有关的数据（User表）
 *
 */
@Mapper
public interface LoginDao {
    /**
     *
     * @param name:验证的用户名
     * @param password:验证的密码
     * @return user对象，select * from user where name=? and password=?,能够查到一条数据
     *         一条数据-----一个user对象
     */
    @Select("select * from user where name=#{name} and password=#{password}")
    public User login(@Param("name") String name, @Param("password") String password);

    @Delete("delete from user where id=#{userId}")
    public boolean delUser(@Param("userId") int userId);

    @Insert("insert into user (name, password) VALUES (#{user.name}, #{user.password})")
    public boolean insertUser(@Param("user") User user);

    @Select("SELECT * FROM user")
    public List<User> getAllUsers();

    @Update("update user set name = #{user.name}, password = #{user.password} WHERE id = #{user.id}")
    public boolean updateUser(@Param("user") User user);

}
