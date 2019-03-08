package com.example.device.mapper;

import com.example.thrift.device.DeviceInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeviceMapper {

    @Select("select deviceName, identify, belong, intro from pe_device where id=#{id} and belong=#{belong}")
    DeviceInfo getDeviceById(@Param("id")int id, @Param("belong")String belong);

    @Select("select deviceName, identify, belong, intro from pe_device where deviceName=#{deviceName} and belong=#{belong}")
    DeviceInfo getDeviceByName(@Param("deviceName") String deviceName, @Param("belong")String belong);

    @Update("update pe_device set intro=#{u.intro} where deviceName=#{u.deviceName} and belong=#{u.belong}")
    void updateDeviceInfo(@Param("u") DeviceInfo deviceInfo);

    @Select("select deviceName, identify, belong, intro from pe_device where belong=#{belong}")
    List<DeviceInfo> getDevices(@Param("belong")String belong);

    @Insert("insert into pe_device(deviceName, identify, belong, intro)" +
            "values(#{u.deviceName}, #{u.identify}, #{u.belong}, #{u.intro})")
    void addDeviceInfo(@Param("u") DeviceInfo deviceInfo);

    @Delete("delete from pe_device where deviceName=#{deviceName} and belong=#{belong}")
    void deleteDevice(@Param("deviceName")String deviceName, @Param("belong")String belong);
}
