package com.example.user.response;

import com.alibaba.fastjson.JSONObject;

public class MessageResponse extends Response {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public MessageResponse(String data) {
        this.data = data;
    }
}
