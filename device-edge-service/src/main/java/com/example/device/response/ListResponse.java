package com.example.device.response;

import com.example.thrift.device.DeviceInfo;
import com.example.thrift.dto.DeviceDTO;

import java.util.List;

public class ListResponse extends Response {
    private List<DeviceDTO> data;

    public ListResponse(List<DeviceDTO> data) {
        this.data = data;
    }

    public List<DeviceDTO> getData() {
        return data;
    }

    public void setData(List<DeviceDTO> data) {
        this.data = data;
    }
}
