package com.iotgateway.coreservice.coreservice.repository;

import com.iotgateway.coreservice.coreservice.model.IotDockerConfigRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IotDockerConfigRequestRepo extends MongoRepository<IotDockerConfigRequest, String> {
}
