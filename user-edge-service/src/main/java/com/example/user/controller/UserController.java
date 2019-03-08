package com.example.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.thrift.dto.UserDTO;
import com.example.thrift.user.UserInfo;
import com.example.user.redis.RedisClient;
import com.example.user.response.LoginResponse;
import com.example.user.response.MessageResponse;
import com.example.user.response.Response;
import com.example.user.thrift.ServiceProvider;
import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.MessageDigest;
import java.util.Random;

@Controller
@RequestMapping(value = "us")
public class UserController {

    @Autowired
    private ServiceProvider serviceProvider;

    @Autowired
    private RedisClient redisClient;

   // 转到登录页面
   @RequestMapping(value = "/login", method = RequestMethod.GET)
   @ResponseBody
   private Response logins() {
       return Response.NEED_REDIRECTION;
   }

    // 发送登录请求
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    private Response login(@RequestBody JSONObject jsonObject) {
        UserInfo userInfo = null;
        try {
            userInfo = serviceProvider.getUserService().getUserByName(jsonObject.getString("username"));
        } catch (TException e) {
            e.printStackTrace();
            return Response.USERNAME_OR_PASSWORD_INVALID;
        }
        if (userInfo == null) {
            return Response.USERNAME_OR_PASSWORD_INVALID;
        }
        if (!userInfo.getPassword().equalsIgnoreCase(md5(jsonObject.getString("password")))) {
            return Response.USERNAME_OR_PASSWORD_INVALID;
        }

        String token = getToken();

        redisClient.set(token, toDTO(userInfo), 3600);

        return new LoginResponse(token);
    }

    // 发送验证码
    @RequestMapping(value = "/sendVerifyCode", method = RequestMethod.POST)
    @ResponseBody
    private Response sendVerifyCode(@RequestParam(value = "email", required = false)String email,
                                     @RequestParam(value = "mobile", required = false)String mobile) {
        String message = "verify code is: ";
        String code = randomCode("0123456789", 6);

        try {
            boolean result = false;
            if (StringUtils.isNotBlank(mobile)) {
                result = serviceProvider.getMessageService().sendMobileMessage(mobile, message + code);
                System.out.println(result);
                redisClient.set(mobile, code);
            } else if (StringUtils.isNotBlank(email)) {
                result = serviceProvider.getMessageService().sendEmailMessage(email, message+code);
                System.out.println(result);
                redisClient.set(email, code);
            } else {
                return Response.MOBILE_OR_EMAIL_IS_REQUIRED;
            }
            if (!result) {
                return Response.SEND_VERIFY_CODE_FAILED;
            } else {
                return Response.SUCCEED;
            }
        } catch (TException e) {
            e.printStackTrace();
            return Response.exception(e);
        }
    }

    // 注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    private Response register(@RequestBody JSONObject jsonObject) {
        if(StringUtils.isBlank(jsonObject.getString("mobile"))
                && StringUtils.isBlank(jsonObject.getString("email"))) {
            return Response.MOBILE_OR_EMAIL_IS_REQUIRED;
        }
        if(StringUtils.isNotBlank(jsonObject.getString("mobile"))) {
            String redisCode = redisClient.get(jsonObject.getString("mobile"));
            if (!jsonObject.getString("verifyCode").equals(redisCode)) {
                return Response.VERIFY_CODE_IS_INVALID;
            }
        } else {
            String redisCode = redisClient.get(jsonObject.getString("email"));
            if(!jsonObject.getString("verifyCode").equals(redisCode)) {
                return Response.VERIFY_CODE_IS_INVALID;
            }
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(jsonObject.getString("username"));
        userInfo.setPassword(md5(jsonObject.getString("password")));
        userInfo.setRealName(jsonObject.getString("realName"));
        userInfo.setEmail(jsonObject.getString("email"));
        userInfo.setMobile(jsonObject.getString("mobile"));
        // 生成唯一的api key
        String apiKey = randomCode("abcdefghijklmnopqrstuvwxyz0123456789", 16);
        userInfo.setApiKey(apiKey);

        try {
            serviceProvider.getUserService().registerUser(userInfo);
        } catch (TException e) {
            e.printStackTrace();
            return Response.exception(e);
        }
        return Response.SUCCEED;
    }

    // 验证是否在登录状态
    @RequestMapping(value = "/authentication", method = RequestMethod.POST)
    @ResponseBody
    public UserDTO authentication(@RequestHeader("token")String token) {
        return redisClient.get(token);
    }

    // 获取用户信息
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public Response user(@RequestHeader("token")String token) {
        UserDTO temp = redisClient.get(token);
        return new MessageResponse(JSON.toJSONString(temp));
    }

    // 修改信息
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public Response user(@RequestHeader("token")String token, @RequestBody JSONObject jsonObject) {
        try {
            UserDTO ui = redisClient.get(token);

            UserInfo info = new UserInfo();
            info.setId(ui.getId());
            info.setUsername(ui.getUsername());
            info.setPassword(ui.getPassword());
            info.setApiKey(ui.getApiKey());
            info.setMobile(ui.getMobile());

            info.setEmail(jsonObject.getString("email"));
            info.setRealName(jsonObject.getString("realName"));

            serviceProvider.getUserService().updateUserInfo(info);
            redisClient.set(token, toDTO(info), 3600);
        } catch (TException e) {
            e.printStackTrace();
            return Response.USER_INFO_UPDATE_FAILED;
        }
        return Response.USER_INFO_UPDATE_SUCCEED;
    }

    private Object toDTO(UserInfo userInfo) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userInfo, userDTO);
        return userDTO;
    }

    private String randomCode(String s, int size) {
        StringBuilder result = new StringBuilder(size);
        Random random = new Random();
        for(int i=0; i<size; i++){
            int loc = random.nextInt(s.length());
            result.append(s.charAt(loc));
        }
        return result.toString();
    }

    private String getToken() {
        return randomCode("abcdefghijklmnopqrstuvwxyz0123456789", 16);
    }

    private String md5(String password) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md5.digest(password.getBytes("utf-8"));
            return HexUtils.toHexString(md5Bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
