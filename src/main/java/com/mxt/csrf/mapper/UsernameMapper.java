package com.mxt.csrf.mapper;

import com.mxt.csrf.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UsernameMapper {

    @Insert("insert into user (userid, name, password) VALUES (#{user.userid}, #{user.name}, #{user.password})")
    public void addUser(@Param("user") User user);
}
