package com.example.data.repository;

import com.example.thrift.data.DataInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DataRepository {

    @Insert("insert into pe_data(id, identify, datetime, value, comment)" +
            "values(#{d.id}, #{d.identify}, #{d.datetime}, #{d.value}, #{d.comment})")
    void addOneData(@Param("d") DataInfo dataInfo);

    @Select("select id, identify, datetime, value, comment from pe_data where identify=#{identify}")
    List<DataInfo> findAllData(@Param("identify")String identify);

    @Select("select id, identify, datetime, value, comment from pe_data where identify=#{identify} " +
            "and datetime < #{datetime}")
    List<DataInfo> toTimeData(@Param("identify")String device_identify,
                              @Param("datetime")String datetime);

    @Select("select id, identify, datetime, value, comment from pe_data where identify=#{identify} " +
            "and datetime BETWEEN #{fromTime} AND #{toTime}")
    List<DataInfo> fromToTimeData(@Param("identify")String device_identify,
                                  @Param("fromTime")String fromTime,
                                  @Param("toTime")String toTime);
}
