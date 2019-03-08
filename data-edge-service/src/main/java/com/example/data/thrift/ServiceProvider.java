package com.example.data.thrift;

import com.example.thrift.data.DataService;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceProvider {

    @Value("${thrift.user.ip}")
    private String serviceIp;

    @Value("${thrift.user.port}")
    private int servicePort;

    private enum ServiceType {
        DATA
    }

    public DataService.Client getDataService() {
        return getService(serviceIp, servicePort, ServiceType.DATA);
    }

    private <T> T getService(String ip, int port, ServiceType serviceType) {
        TSocket socket = new TSocket(ip, port, 3000);
        TTransport transport = new TFramedTransport(socket);
        try {
            transport.open();
        } catch (TTransportException e) {
            e.printStackTrace();
            return null;
        }
        TProtocol protocol = new TBinaryProtocol(transport);

        TServiceClient result = null;
        switch (serviceType) {
            case DATA:
                result = new DataService.Client(protocol);
                break;
        }
        return (T)result;
    }
}
