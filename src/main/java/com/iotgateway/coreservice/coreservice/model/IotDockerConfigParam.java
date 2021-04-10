package com.iotgateway.coreservice.coreservice.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class IotDockerConfigParam extends IotRequestParam {
    private String type = "docker";
    private String containerID = "";
}
