package com.knowledge.point.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RabbitController {
    @Autowired
    private RabbitMqSender rabbitMqSender;

    @RequestMapping("/rabbit")
    public void TestRabbitMQ(){
        rabbitMqSender.send();
    }
}
