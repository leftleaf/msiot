package com.example.device.filter;

import com.example.thrift.dto.UserDTO;
import com.example.user.client.LoginFitter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeviceFilter extends LoginFitter {
    @Override
    protected void login(HttpServletRequest request, HttpServletResponse response, UserDTO userDTO) {
        request.setAttribute("user", userDTO);
    }
}
