namespace java com.example.thrift.device

struct DeviceInfo {
    1:i32 id,
    2:string deviceName,
    3:string identify,
    4:string belong,
    5:string intro
}

service DeviceService {
    // find information about device
    DeviceInfo getDeviceById(1:i32 id, 2:string belong);
    DeviceInfo getDeviceByName(1:string deviceName, 2:string belong);

    // find information about all devices
    list<DeviceInfo> getDevices(1:string belong);

    // update device information
    void updateDeviceInfo(1:DeviceInfo deviceInfo);

    // add device information
    void addDeviceInfo(1:DeviceInfo deviceInfo);

    // delete device
    void deleteDevice(1:string deviceName, 2:string belong);
}