package com.example.user.mapper;

import com.example.thrift.user.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select id, username, password, realName, email, mobile, apiKey " +
            "from pe_user where id=#{id}")
    UserInfo getUserById(@Param("id")int id);

    @Select("select id, username, password, realName, email, mobile, apiKey " +
            "from pe_user where username=#{username}")
    UserInfo getUserByName(@Param("username")String username);

    @Update("update pe_user set username=#{u.username}, password=#{u.password}, realName=#{u.realName}," +
            "email=#{u.email}, mobile=#{u.mobile}, apiKey=#{u.apiKey} where id=#{u.id}")
    void updateUserInfo(@Param("u")UserInfo userInfo);

    @Insert("insert into pe_user(username, password, realName, email, mobile, apiKey)" +
            "values(#{u.username}, #{u.password}, #{u.realName}, #{u.email}, #{u.mobile}, #{u.apiKey})")
    void registerUser(@Param("u") UserInfo userInfo);

}
