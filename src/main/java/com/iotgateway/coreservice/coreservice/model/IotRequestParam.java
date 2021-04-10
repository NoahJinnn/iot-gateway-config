package com.iotgateway.coreservice.coreservice.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = IotDockerConfigParam.class, name = "docker"),
        @JsonSubTypes.Type(value = IotBashConfigParam.class, name = "bash")
})
public abstract class IotRequestParam<T>  {
    private T paramChild;
}
