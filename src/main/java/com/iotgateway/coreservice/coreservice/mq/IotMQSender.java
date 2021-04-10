package com.iotgateway.coreservice.coreservice.mq;

import com.iotgateway.coreservice.coreservice.constant.IotRabbitMQConstants;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class IotMQSender {
    private final RabbitTemplate rabbitTemplate;

    public IotMQSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(String topic, Object msg) {
        rabbitTemplate.convertAndSend(topic, msg);
    }
}
