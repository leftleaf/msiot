package com.example.data.response;

import com.example.thrift.dto.DataDTO;

import java.util.List;

public class ListResponse extends Response {
    private List<DataDTO> data;

    public ListResponse(List<DataDTO> data) {
        this.data = data;
    }

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }
}
