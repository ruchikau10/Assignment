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

    //Read Data
    @GetMapping("/api/get/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

   //Save Data
   @PostMapping("/newapi/customers")
    public String addCustomer(@RequestBody Customer  customer){
       customerService.addCustomer(customer);
       return customer.getCheckoutId();
   }

   //Update Data
    @PutMapping("/update/customers/{checkoutid}")
    public  void updateCustomer(@RequestBody Customer customer,@PathVariable ("checkoutId") String checkoutId){
        customerService.updateCustomer(customer, checkoutId);
    }

    //Delete Data
    @DeleteMapping("/delete/{checkoutId}")
    public String deleteCustomer(@PathVariable ("checkoutId") String checkoutId){
        customerService.deleteCustomer(checkoutId);
        return "Record Deleted";
    }

}
