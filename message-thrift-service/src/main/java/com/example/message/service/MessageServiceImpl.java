package com.example.message.service;

import com.example.thrift.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService.Iface {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public boolean sendEmailMessage(String email, String message) {
        return sendEmail(email, message);
    }

    private boolean sendEmail(String email, String message) {
        SimpleMailMessage message1 = new SimpleMailMessage();
        message1.setFrom(from);
        message1.setSubject("The Verity Code is: ");
        message1.setTo(email);
        message1.setText(message);

        javaMailSender.send(message1);
        System.out.println("send verity code successful!");
        return true;
    }

    @Override
    public boolean sendMobileMessage(String mobile, String message) {
        System.out.println("mobile" + mobile + ", message:" + message);
        return true;
    }
}
