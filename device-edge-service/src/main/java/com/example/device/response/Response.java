package com.example.device.response;

import java.io.Serializable;

public class Response implements Serializable {
    private String code;
    private String message;

    public static final Response SUCCESS = new Response();
    public static final Response ADD_DEVICE_FAILED = new Response("2001", "add device failed");
    public static final Response DELETE_DEVICE_SUCCESS = new Response("2002", "delete device success");
    public static final Response DELETE_DEVICE_FAILED = new Response("2003", "delete device failed");
    public static final Response UPDATE_DEVICE_FAILED = new Response("2004", "update device failed");

    public Response() {
        this.code = "0";
        this.message = "success";
    }

    public Response(String code, String message) {
        this.code = code;
        this.message = message;
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
