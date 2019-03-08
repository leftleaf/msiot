package com.example.thrift.dto;

import java.io.Serializable;

public class DeviceDTO implements Serializable {
    private int id;
    private String deviceName;
    private String identify;
    private String belong;
    private String intro;

    @Override
    public String toString() {
        return "DeviceDTO{" +
                "id=" + id +
                ", deviceName='" + deviceName + '\'' +
                ", identify='" + identify + '\'' +
                ", belong='" + belong + '\'' +
                ", intro='" + intro + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
