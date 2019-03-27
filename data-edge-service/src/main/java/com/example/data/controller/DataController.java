package com.example.data.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.data.response.ListResponse;
import com.example.data.response.Response;
import com.example.data.thrift.ServiceProvider;
import com.example.thrift.data.DataInfo;
import com.example.thrift.dto.DataDTO;
import org.apache.thrift.TException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/da")
@CrossOrigin
public class DataController {
    @Autowired
    private ServiceProvider serviceProvider;

    @RequestMapping(value = "/data", method = RequestMethod.GET)
    @ResponseBody
    private Response getAll(@RequestParam("identify")String identify) {
        try {
            List<DataDTO> dtos = new ArrayList<>();
            for (DataInfo dataInfo : serviceProvider.getDataService().findAllData(identify)) {
                dtos.add(toDTO(dataInfo));
            }
            return new ListResponse(dtos);

        } catch (TException e) {
            e.printStackTrace();
            return Response.exception(e);
        }
    }

    @RequestMapping(value = "/data", method = RequestMethod.POST)
    @ResponseBody
    private Response addData(@RequestBody DataInfo dataInfo) {
        try {
            serviceProvider.getDataService().addOneData(dataInfo);
            return Response.SUCCESS;
        } catch (TException e) {
            e.printStackTrace();
            return Response.ADD_DATA_FAILED;
        }
    }

    @RequestMapping(value = "/toTimeData", method = RequestMethod.GET)
    @ResponseBody
    private Response toTimeData(@RequestParam("identify")String identify,
                                 @RequestParam("datetime")String datetime) {
        try {
            List<DataDTO> dtos = new ArrayList<>();
            List<DataInfo> d =  serviceProvider.getDataService().toTimeData(identify, datetime);
            for(DataInfo dataInfo : d) {
                dtos.add(toDTO(dataInfo));
            }
            return new ListResponse(dtos);
        } catch (TException e) {
            e.printStackTrace();
            return Response.exception(e);
        }
    }

    @RequestMapping(value = "/fromToTimeData", method = RequestMethod.GET)
    @ResponseBody
    private Response fromToTimeData(@RequestParam("identify")String identify,
                                     @RequestParam("fromTime")String fromTime,
                                     @RequestParam("toTime")String toTime) {
        try {
            List<DataDTO> dtos = new ArrayList<>();
            List<DataInfo> d =  serviceProvider.getDataService().fromToTimeData(identify, fromTime, toTime);
            for(DataInfo dataInfo : d) {
                dtos.add(toDTO(dataInfo));
            }
            return new ListResponse(dtos);
        } catch (TException e) {
            e.printStackTrace();
            return Response.exception(e);
        }
    }

    private DataDTO toDTO(DataInfo dataInfo) {
        DataDTO dataDTO = new DataDTO();
        BeanUtils.copyProperties(dataInfo, dataDTO);
        return dataDTO;
    }
}


