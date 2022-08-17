package com.springboot.assignmentapi.service;

import com.springboot.assignmentapi.model.Customer;
import com.springboot.assignmentapi.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class CustomerServiceImplem implements CustomerService{

    @Autowired
    public CustomerRepo customerRepo;

    @Autowired
    public VehicleService vehicleService;

    @Autowired
    public ProfileService profileService;

    @Override
    public String addCustomer(Customer customer) {
        String requestId;
        while(true){
            Random random = new Random();
            requestId = String.valueOf(Math.abs(random.nextLong()));
            if(customerRepo.findCustomerById(requestId)==null){
                break;
            }
        }
        customer.setCheckoutId(requestId);
        Customer customer1= customerRepo.save(customer);
        return customer1.getCheckoutId();
    }

    @Override
    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }

    @Override
    public void deleteCustomer(String checkoutId){
        Customer customer = customerRepo.findCustomerById(checkoutId);
        customerRepo.delete(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, String checkoutId) {
        Customer customer1= customerRepo.findById(Integer.valueOf(checkoutId)).get();

        if(Objects.nonNull(customer.getCheckoutId())&&"".equalsIgnoreCase(customer.getCheckoutId())){
            customer1.setCheckoutId(customer.getCheckoutId());
        }

        if(Objects.nonNull(customer.getCustomerName())&& !"".equalsIgnoreCase(customer.getCustomerName())){
            customer1.setCustomerName(customer.getCustomerName());
        }

        if(Objects.nonNull(customer.getCustomerEmail())&& !"".equalsIgnoreCase(customer.getCustomerEmail())){
            customer1.setCustomerEmail(customer.getCustomerEmail());
        }

        if(Objects.nonNull(customer.getCustomerPhoneNo())&& !"".equalsIgnoreCase(customer.getCustomerPhoneNo())){
            customer1.setCustomerPhoneNo(customer.getCustomerPhoneNo());
        }

        if(Objects.nonNull(customer.getRequestId())&&"".equalsIgnoreCase(customer.getRequestId())){
            customer1.setRequestId(customer.getRequestId());
        }

        return customerRepo.save(customer1);
    }

    @Override
    public Customer getIndividualCustomer(String checkoutId) {
        Customer customer=customerRepo.findCustomerById(checkoutId);
        String customerRequestId =customer.getRequestId();
        String customerResultId =customer.getResultId();
        vehicleService.getVehicleByRequestid(customerRequestId);
        profileService.getProfile(customerResultId);
        return customer;
    }

}
