package com.iotgateway.coreservice.coreservice.mq;

import com.iotgateway.coreservice.coreservice.constant.IotRabbitMQConstants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class IotMQSender {
    private final AmqpTemplate amqpTemplate;

    public IotMQSender(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void send(String exchangeTopic, String routingKey, Object msg) {
        amqpTemplate.convertAndSend(exchangeTopic, routingKey, msg);
    }
}
