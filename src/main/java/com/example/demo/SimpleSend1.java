package com.example.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SimpleSend1 {


    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String message = "Hello Spring Boot111 " + simpleDateFormat.format(new Date());
        amqpTemplate.convertAndSend("simple", message);
//        System.out.println("消息推送成功！");
    }
}