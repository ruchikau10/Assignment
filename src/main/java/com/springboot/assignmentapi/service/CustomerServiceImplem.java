package com.springboot.assignmentapi.service;

import com.springboot.assignmentapi.model.Customer;
import com.springboot.assignmentapi.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    @Override
    public void deleteCustomer(String checkoutId){
        Customer customer = customerRepo.findbyCustomerById(checkoutId);
        customerRepo.delete(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, String checkoutId) {
        Customer customer1= customerRepo.findById(Integer.valueOf(checkoutId)).get();

        if(Objects.nonNull(customer.getCustomerName())&& !"".equalsIgnoreCase(customer.getCustomerName())){
            customer1.setCustomerName(customer.getCustomerName());
        }

        if(Objects.nonNull(customer.getCustomerEmail())&& !"".equalsIgnoreCase(customer.getCustomerEmail())){
            customer1.setCustomerEmail(customer.getCustomerEmail());
        }

        if(Objects.nonNull(customer.getCustomerPhoneNo())&& !"".equalsIgnoreCase(customer.getCustomerPhoneNo())){
            customer1.setCustomerPhoneNo(customer.getCustomerPhoneNo());
        }
        return customerRepo.save(customer1);
    }


}
