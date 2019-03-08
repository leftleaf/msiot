package com.example.thrift.dto;

import java.io.Serializable;

public class DataDTO implements Serializable {
    private String identify;
    private String value;
    private String datetime;
    private String comment;

    public DataDTO(String identify, String value, String datetime, String comment) {
        this.identify = identify;
        this.value = value;
        this.datetime = datetime;
        this.comment = comment;
    }

    public DataDTO() {
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
