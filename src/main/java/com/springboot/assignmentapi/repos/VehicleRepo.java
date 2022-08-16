package com.springboot.assignmentapi.repos;

import com.springboot.assignmentapi.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface VehicleRepo extends MongoRepository<Vehicle,String> {

   @Query("{requestId: ?0")
   Vehicle findByRequestId(String requestId);
}
