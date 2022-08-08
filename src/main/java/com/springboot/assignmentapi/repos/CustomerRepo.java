package com.springboot.assignmentapi.repos;

import com.springboot.assignmentapi.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface CustomerRepo extends MongoRepository<Customer,Integer>{

}
