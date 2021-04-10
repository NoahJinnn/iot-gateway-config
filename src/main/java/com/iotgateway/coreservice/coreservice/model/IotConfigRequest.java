package com.iotgateway.coreservice.coreservice.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class IotConfigRequest {
    private String type = "";
    private String function = "";
    private IotRequestParam<? extends IotParamChild> para;
}
