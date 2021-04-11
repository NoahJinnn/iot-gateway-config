package com.iotgateway.coreservice.coreservice.repository;

import com.iotgateway.coreservice.coreservice.model.IotBashConfigRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IotBashConfigRequestRepo extends MongoRepository<IotBashConfigRequest, String> {
}
