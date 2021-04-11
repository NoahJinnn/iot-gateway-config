package com.iotgateway.coreservice.coreservice.service;

import com.iotgateway.coreservice.coreservice.constant.IotRabbitMQConstants;
import com.iotgateway.coreservice.coreservice.model.IotBashConfigRequest;
import com.iotgateway.coreservice.coreservice.model.IotDockerConfigRequest;
import com.iotgateway.coreservice.coreservice.mq.IotMQReceiver;
import com.iotgateway.coreservice.coreservice.mq.IotMQSender;
import com.iotgateway.coreservice.coreservice.repository.IotBashConfigRequestRepo;
import com.iotgateway.coreservice.coreservice.repository.IotDockerConfigRequestRepo;
import org.springframework.stereotype.Service;

@Service
public class IotConfigService {
    private final IotDockerConfigRequestRepo iotDockerConfigRequestRepo;
    private final IotBashConfigRequestRepo iotBashConfigRequestRepo;
    private final IotMQSender iotMQSender;
    private final IotMQReceiver iotMQReceiver;

    public IotConfigService(IotDockerConfigRequestRepo iotDockerConfigRequestRepo, IotBashConfigRequestRepo iotBashConfigRequestRepo, IotMQSender iotMQSender, IotMQReceiver iotMQReceiver) {
        this.iotDockerConfigRequestRepo = iotDockerConfigRequestRepo;
        this.iotBashConfigRequestRepo = iotBashConfigRequestRepo;
        this.iotMQSender = iotMQSender;
        this.iotMQReceiver = iotMQReceiver;
    }

    public IotDockerConfigRequest createIotDockerConfig(IotDockerConfigRequest iotDockerConfigRequest) {
        iotMQSender.send(IotRabbitMQConstants.EXCHANGE_TOPIC, IotRabbitMQConstants.ROUTING_KEY, iotDockerConfigRequest);
        return iotDockerConfigRequestRepo.save(iotDockerConfigRequest);
    }

    public IotBashConfigRequest createIotBashConfig(IotBashConfigRequest iotBashConfigRequest) {
        return iotBashConfigRequestRepo.save(iotBashConfigRequest);
    }
}
