package com.springboot.assignmentapi.repos;

import com.springboot.assignmentapi.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CustomerRepo extends MongoRepository<Customer,Integer>{

}
