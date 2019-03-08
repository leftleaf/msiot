package com.example.data.filter;

import com.example.thrift.dto.UserDTO;
import com.example.user.client.LoginFitter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataFilter extends LoginFitter {
    @Override
    protected void login(HttpServletRequest request, HttpServletResponse response, UserDTO userDTO) {

    }
}
