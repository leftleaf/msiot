namespace java com.example.thrift.message

service MessageService {

    bool sendEmailMessage(1:string email, 2:string message)

    bool sendMobileMessage(1:string mobile, 2:string message)

}