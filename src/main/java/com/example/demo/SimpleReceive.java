package com.example.demo;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "simple")
public class SimpleReceive {

    @RabbitHandler
    public void process(String message) {
        System.out.println("------------Receive :{}-----"+ message);
    }

}