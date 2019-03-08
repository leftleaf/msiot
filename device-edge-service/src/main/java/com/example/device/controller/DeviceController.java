package com.example.device.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.device.redis.RedisClient;
import com.example.device.response.ListResponse;
import com.example.device.response.MessageResponse;
import com.example.device.response.Response;
import com.example.device.thrift.ServiceProvider;
import com.example.thrift.device.DeviceInfo;
import com.example.thrift.dto.DeviceDTO;
import com.example.thrift.dto.UserDTO;
import com.example.thrift.user.UserInfo;
import org.apache.thrift.TException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping(value = "de")
public class DeviceController {

    @Autowired
    private ServiceProvider serviceProvider;

    @Autowired
    private RedisClient redisClient;

    // 获取设备列表
    @RequestMapping(value = "/devices", method = RequestMethod.GET)
    @ResponseBody
    public Response devices(@RequestHeader("apiKey")String belong) {
        try {
            List<DeviceDTO> dtos = new ArrayList<DeviceDTO>();
            for (DeviceInfo deviceInfo : serviceProvider.getDeviceService().getDevices(belong)) {
                dtos.add(toDTO(deviceInfo));
            }
            return new ListResponse(dtos);
        } catch (TException e) {
            e.printStackTrace();
            return Response.exception(e);
        }
    }

    //查看单台设备的信息
    @RequestMapping(value = "/device", method = RequestMethod.GET)
    @ResponseBody
    public Response device(@RequestParam("deviceName")String deviceName,
                             @RequestHeader("apiKey")String belong) {
        try {
            DeviceInfo d = serviceProvider.getDeviceService().getDeviceByName(deviceName, belong);
            return new MessageResponse(toDTO(d));
        } catch (TException e) {
            e.printStackTrace();
            return Response.exception(e);
        }
    }

    // 创建新设备
    @RequestMapping(value = "/device", method = RequestMethod.POST)
    @ResponseBody
    public Response device(@RequestBody JSONObject jsonObject,
                           @RequestHeader("apiKey")String belong) {

        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setDeviceName(jsonObject.getString("deviceName"));
        deviceInfo.setIdentify(randomCode("abcdefghijklmnopqrstuvwxyz1234567890", 16));
        deviceInfo.setBelong(belong);
        deviceInfo.setIntro(jsonObject.getString("intro"));

        try {
            serviceProvider.getDeviceService().addDeviceInfo(deviceInfo);
            return Response.SUCCESS;
        } catch (TException e) {
            e.printStackTrace();
            return Response.ADD_DEVICE_FAILED;
        }
    }

    // 修改设备
    @RequestMapping(value = "/device", method = RequestMethod.PUT)
    @ResponseBody
    public Response upd_device(@RequestBody JSONObject jsonObject,
                                @RequestHeader("apikey")String belong){
        try {
            DeviceInfo deviceInfo = new DeviceInfo();
            deviceInfo.setIntro(jsonObject.getString("intro"));
            deviceInfo.setBelong(belong);
            deviceInfo.setDeviceName(jsonObject.getString("deviceName"));
            serviceProvider.getDeviceService().updateDeviceInfo(deviceInfo);
            return Response.SUCCESS;
        } catch (TException e) {
            e.printStackTrace();
            return Response.UPDATE_DEVICE_FAILED;
        }

    }

    // 删除设备
    @RequestMapping(value = "/device", method = RequestMethod.DELETE)
    @ResponseBody
    public Response del_device(@RequestParam("deviceName")String deviceName,
                                @RequestHeader("apiKey")String belong) {
        try {
            serviceProvider.getDeviceService().deleteDevice(deviceName, belong);
            return Response.DELETE_DEVICE_SUCCESS;
        } catch (TException e) {
            e.printStackTrace();
        }
        return Response.DELETE_DEVICE_FAILED;
    }

    private DeviceDTO toDTO(DeviceInfo deviceInfo) {
        DeviceDTO deviceDTO = new DeviceDTO();
        BeanUtils.copyProperties(deviceInfo, deviceDTO);
        return deviceDTO;
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

}
