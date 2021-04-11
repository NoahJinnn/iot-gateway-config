package com.iotgateway.coreservice.coreservice.controller;

import com.iotgateway.coreservice.coreservice.model.IotDockerConfigRequest;
import com.iotgateway.coreservice.coreservice.service.IotConfigService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IotConfigController {

    private final IotConfigService iotConfigService;

    public IotConfigController(IotConfigService iotConfigService) {
        this.iotConfigService = iotConfigService;
    }

    @PostMapping
    private ResponseEntity<String> getConfig(@RequestBody IotDockerConfigRequest configRequest) {
        iotConfigService.createIotDockerConfig(configRequest);
        return new ResponseEntity("Succes", HttpStatus.OK);
    }
}
