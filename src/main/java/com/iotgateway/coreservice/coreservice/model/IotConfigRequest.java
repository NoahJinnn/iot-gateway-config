package com.iotgateway.coreservice.coreservice.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public abstract class IotConfigRequest {
    protected String type = "";
    protected String function = "";
}
