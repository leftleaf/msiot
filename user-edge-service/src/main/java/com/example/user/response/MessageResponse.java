package com.example.user.response;

import com.alibaba.fastjson.JSONObject;
import com.example.thrift.dto.UserDTO;

import java.util.List;

public class MessageResponse extends Response {
    private List<UserDTO> data;

    public List<UserDTO> getData() {
        return data;
    }

    public void setData(List<UserDTO> data) {
        this.data = data;
    }

    public MessageResponse(List<UserDTO> data) {
        this.data = data;
    }
}
