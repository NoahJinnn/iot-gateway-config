package com.iotgateway.coreservice.coreservice.model;

import com.iotgateway.coreservice.coreservice.constant.IotMongoDBConstants;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString(callSuper = true)
@Document(collation = IotMongoDBConstants.CONFIG_COLLECTION)
public class IotDockerConfigRequest extends IotConfigRequest {
    private IotDockerConfigPara para;
}
