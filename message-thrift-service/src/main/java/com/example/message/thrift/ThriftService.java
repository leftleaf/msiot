package com.example.message.thrift;

import com.example.thrift.message.MessageService;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ThriftService {
    @Value("${spring.thrift.port}")
    private int servicePort;

    @Autowired
    private MessageService.Iface messageService;

    @PostConstruct
    public void startThriftServer() {
//        TProcessor processor = new MessageService.Processor<>(messageService);
//        TServerSocket transport = null;
//        try {
//            transport = new TServerSocket(servicePort);
//            TThreadPoolServer.Args args = new TThreadPoolServer.Args(transport);
//            TBinaryProtocol.Factory proFactory = new TBinaryProtocol.Factory(true,true);
//
//            args.processor(processor);
//            args.protocolFactory(proFactory);
//
//            System.out.println("message service start");
//            TServer server = new TThreadPoolServer(args);
//            server.serve();
//        } catch (TTransportException e) {
//            System.out.println("message service error");
//            e.printStackTrace();
//        }
//    }
        TProcessor processor = new MessageService.Processor<>(messageService);

        TNonblockingServerSocket socket = null;
        try {
            socket = new TNonblockingServerSocket(servicePort);
        } catch (TTransportException e) {
            e.printStackTrace();
        }

        TNonblockingServer.Args args = new TNonblockingServer.Args(socket);
        args.processor(processor);
        args.transportFactory(new TFramedTransport.Factory());
        args.protocolFactory(new TBinaryProtocol.Factory());

        TServer server = new TNonblockingServer(args);
        System.out.println("message server start");
        server.serve();
        System.out.println("message server stop");
    }
}
