package com.iotgateway.coreservice.coreservice.mq;

import com.iotgateway.coreservice.coreservice.model.IotDockerConfigRequest;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

@Component
public class IotMQReceiver {
    public void receive(Object msg) {
        System.out.println("Received <" + msg + ">");
    }
}
