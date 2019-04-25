package com.knowledge.point.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues="queue")
public class RabbitRecive {
   @RabbitHandler
    public  void recive(String message){

       System.out.println("收到消息"+message);
    }
}
