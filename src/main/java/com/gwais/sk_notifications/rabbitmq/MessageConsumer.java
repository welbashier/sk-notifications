package com.gwais.sk_notifications.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @RabbitListener(queues = RabbitMQConfig.EMAIL_QUEUE)
    public void consumeMessage(String message) {
    	
        System.out.println("Received message from email-queue: " + message);
        
        // TODO: implement the logic to handle the message and email it
    }
}

