namespace java com.example.thrift.data

struct DataInfo {
    1:string id;
    2:string identify;
    3:string datetime;
    4:string value;
    5:string comment;
}

service DataService {
    // add data
    void addOneData(1:DataInfo dataInfo);

    // find data
    list<DataInfo> findAllData(1:string identify);
    list<DataInfo> toTimeData(1:string identify, 2:string datetime);
    list<DataInfo> fromToTimeData(1:string identify, 2:string fromTime, 3:string toTime);

}