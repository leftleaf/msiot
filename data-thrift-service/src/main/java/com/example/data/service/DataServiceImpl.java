package com.example.data.service;

import com.example.data.repository.DataRepository;
import com.example.thrift.data.DataInfo;
import com.example.thrift.data.DataService;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService.Iface {

    @Autowired
    private DataRepository dataRepository;

    @Override
    public void addOneData(DataInfo dataInfo) throws TException {
        dataRepository.addOneData(dataInfo);
    }

    @Override
    public List<DataInfo> findAllData(String identify) throws TException {
        return dataRepository.findAllData(identify);
    }

    @Override
    public List<DataInfo> toTimeData(String device_identify, String datetime) throws TException {
        return dataRepository.toTimeData(device_identify, datetime);
    }

    @Override
    public List<DataInfo> fromToTimeData(String device_identify, String fromTime, String toTime) throws TException {
        return dataRepository.fromToTimeData(device_identify, fromTime, toTime);
    }
}
