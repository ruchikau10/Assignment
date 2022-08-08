package com.springboot.assignmentapi.service;

import com.springboot.assignmentapi.model.Customer;
import com.springboot.assignmentapi.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImplem implements CustomerService{

    @Autowired
    public CustomerRepo customerRepo;

    @Override
    public String addCustomer(Customer customer) {
        Customer customer1= customerRepo.save(customer);
        return customer1.getCheckoutId();
    }

    @Override
    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }
}
