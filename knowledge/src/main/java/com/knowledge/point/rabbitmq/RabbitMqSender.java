package com.knowledge.point.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqSender implements RabbitTemplate.ConfirmCallback {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public  void send(){

        amqpTemplate.convertAndSend("queue","helloluohao");
    }

    public void sendObject(){

    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {

    }
}
