package com.example.device.response;

import com.example.thrift.dto.DeviceDTO;

public class MessageResponse extends Response {
    private DeviceDTO data;

    public MessageResponse(DeviceDTO data) {
        this.data = data;
    }

    public DeviceDTO getData() {
        return data;
    }

    public void setData(DeviceDTO data) {
        this.data = data;
    }
}
