package com.example.device.service;

import com.example.device.mapper.DeviceMapper;
import com.example.thrift.device.DeviceInfo;
import com.example.thrift.device.DeviceService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService.Iface {

    @Autowired
    private DeviceMapper deviceMapper;


    @Override
    public DeviceInfo getDeviceById(int id, String belong) throws TException {
        return deviceMapper.getDeviceById(id, belong);
    }

    @Override
    public DeviceInfo getDeviceByName(String deviceName, String belong) throws TException {
        return deviceMapper.getDeviceByName(deviceName, belong);
    }

    @Override
    public List<DeviceInfo> getDevices(String belong) throws TException {
        return deviceMapper.getDevices(belong);
    }

    @Override
    public void updateDeviceInfo(DeviceInfo deviceInfo) throws TException {
        deviceMapper.updateDeviceInfo(deviceInfo);
    }

    @Override
    public void addDeviceInfo(DeviceInfo deviceInfo) throws TException {
        deviceMapper.addDeviceInfo(deviceInfo);
    }

    @Override
    public void deleteDevice(String deviceName, String belong) throws TException {
        deviceMapper.deleteDevice(deviceName, belong);
    }
}
