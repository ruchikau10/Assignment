package com.springboot.assignmentapi.controller;

import com.springboot.assignmentapi.model.Customer;
import com.springboot.assignmentapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    @PostMapping("/api/add/customer")
    public String addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
        return customer.getCheckoutId();
    }

}
