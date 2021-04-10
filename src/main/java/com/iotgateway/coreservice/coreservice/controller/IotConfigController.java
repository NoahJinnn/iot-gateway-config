package com.iotgateway.coreservice.coreservice.controller;

import com.iotgateway.coreservice.coreservice.model.IotConfigRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IotConfigController {
    @PostMapping
    private ResponseEntity<String> getConfig(@RequestBody IotConfigRequest configRequest) {
        System.out.println(configRequest.toString());
        return new ResponseEntity("Succes", HttpStatus.OK);
    }
}
