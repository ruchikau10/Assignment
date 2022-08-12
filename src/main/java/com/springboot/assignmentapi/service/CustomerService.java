package com.springboot.assignmentapi.service;

import com.springboot.assignmentapi.model.Customer;

import java.util.List;

public interface CustomerService {
    String addCustomer(Customer customer);

    List<Customer> getCustomers();

    void deleteCustomer(String checkoutId);

    Customer updateCustomer(Customer customer, String checkoutid);
}
