package com.gwais.sk_notifications.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gwais.sk_notifications.dto.EmailRequest;
import com.gwais.sk_notifications.service.EmailService;

@Service
public class MessageConsumer {

	@Autowired
	EmailService emailService;
	
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    @RabbitListener(queues = RabbitMQConfig.EMAIL_QUEUE)
    public void consumeEmailRequest(String message) {

        try {
        	// convert message back to an EmailRequest object
            EmailRequest receivedEmailRequest = objectMapper.readValue(message, EmailRequest.class);
            System.out.println("Received object from email-queue: " + receivedEmailRequest);
            
            // send an email out
            emailService.sendHtmlEmailRequest(receivedEmailRequest);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

