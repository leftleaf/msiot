package com.example.data.response;

import java.io.Serializable;

public class Response implements Serializable {
    private String code;
    private String message;

    public static final Response SUCCESS = new Response();
    public static final Response ADD_DATA_FAILED = new Response("3001", "add data failed");

    public Response(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Response() {
        this.code = "0";
        this.message = "success";
    }

    public static Response exception(Exception e) {
        return new Response("9999", e.getMessage());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
