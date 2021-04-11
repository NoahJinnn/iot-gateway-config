package com.iotgateway.coreservice.coreservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IotDockerConfigPara {
    private String containerID = "";
}
