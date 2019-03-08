package com.example.user.thrift;

import com.example.thrift.user.UserService;
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
    private int servicePort;

    @Autowired
    private UserService.Iface userService;

    @PostConstruct
    public void startThriftServer() {

        TProcessor processor = new UserService.Processor<>(userService);

        TNonblockingServerSocket socket = null;
        try {
            socket = new TNonblockingServerSocket(servicePort);
            TNonblockingServer.Args args = new TNonblockingServer.Args(socket);
            args.processor(processor);
            args.transportFactory(new TFramedTransport.Factory());
            args.protocolFactory(new TBinaryProtocol.Factory());

            TServer server = new TNonblockingServer(args);
            System.out.println("user-thrift-service start");
            server.serve();
        } catch (TTransportException e) {
            e.printStackTrace();
            socket.close();
        }
    }
}
