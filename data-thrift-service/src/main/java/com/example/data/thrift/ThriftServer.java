package com.example.data.thrift;

import com.example.thrift.data.DataService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ThriftServer {

    @Value("${server.port}")
    private int ServerPort;

    @Autowired
    private DataService.Iface dataService;

    @PostConstruct
    public void startThriftServer() {

        TProcessor processor = new DataService.Processor<>(dataService);

        TNonblockingServerSocket socket = null;
        try {
            socket = new TNonblockingServerSocket(ServerPort);
        } catch (TTransportException e) {
            e.printStackTrace();
        }

        TNonblockingServer.Args args = new TNonblockingServer.Args(socket);
        args.processor(processor);
        args.transportFactory(new TFramedTransport.Factory());
        args.protocolFactory(new TBinaryProtocol.Factory());

        TServer server = new TNonblockingServer(args);
        System.out.println("start server");
        server.serve();
    }
}
