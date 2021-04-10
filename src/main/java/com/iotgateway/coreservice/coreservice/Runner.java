//package com.iotgateway.coreservice.coreservice;
//
//import com.iotgateway.coreservice.coreservice.constant.IotRabbitMQConstants;
//import com.iotgateway.coreservice.coreservice.mq.IotMQReceiver;
//import com.iotgateway.coreservice.coreservice.mq.IotMQSender;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Runner implements CommandLineRunner {
//
//    private final IotMQReceiver iotMQReceiver;
//    private final IotMQSender iotMQSender;
//
//    @Autowired
//    public Runner(IotMQReceiver iotMQReceiver, IotMQSender iotMQSender) {
//        this.iotMQReceiver = iotMQReceiver;
//        this.iotMQSender = iotMQSender;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        iotMQSender.send(IotRabbitMQConstants.EXCHANGE_TOPIC, "Test");
//
//    }
//}
