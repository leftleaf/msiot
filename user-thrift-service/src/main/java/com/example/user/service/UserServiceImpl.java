package com.example.user.service;

import com.example.thrift.user.UserInfo;
import com.example.thrift.user.UserService;
import com.example.user.mapper.UserMapper;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService.Iface {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfo getUserById(int id) throws TException {
        return userMapper.getUserById(id);
    }

    @Override
    public UserInfo getUserByName(String name) throws TException {
        return userMapper.getUserByName(name);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) throws TException {
        userMapper.updateUserInfo(userInfo);
    }

    @Override
    public void registerUser(UserInfo userInfo) throws TException {
        userMapper.registerUser(userInfo);
    }
}
