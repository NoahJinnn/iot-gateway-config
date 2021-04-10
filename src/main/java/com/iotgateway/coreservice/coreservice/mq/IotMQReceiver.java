package com.iotgateway.coreservice.coreservice.mq;

import org.springframework.stereotype.Component;

@Component
public class IotMQReceiver {
    public void receive(String msg) {
        System.out.println("Received <" + msg + ">");
    }
}
