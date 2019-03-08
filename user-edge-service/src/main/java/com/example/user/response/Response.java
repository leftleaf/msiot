package com.example.user.response;

import java.io.Serializable;

public class Response implements Serializable {

    private String code;
    private String message;

    public static final Response USERNAME_OR_PASSWORD_INVALID = new Response("1001", "username or password invalid");
    public static final Response MOBILE_OR_EMAIL_IS_REQUIRED = new Response("1002", "mobile or email is required");
    public static final Response SEND_VERIFY_CODE_FAILED = new Response("1003", "send verify code failed");
    public static final Response VERIFY_CODE_IS_INVALID = new Response("1004", "verify code is invalid");
    public static final Response SUCCEED = new Response();
    public static final Response USER_INFO_UPDATE_SUCCEED = new Response("1005", "user info update succeed");
    public static final Response USER_INFO_UPDATE_FAILED = new Response("1006", "user info update failed");
    public static final Response USER_INFO_IS_NEED = new Response("1007", "user info is need");
    public static final Response NEED_REDIRECTION = new Response("1008", "need redirection");

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
