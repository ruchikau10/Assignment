package com.springboot.assignmentapi.controller;

import com.springboot.assignmentapi.model.Customer;
import com.springboot.assignmentapi.model.Profile;
import com.springboot.assignmentapi.model.Vehicle;
import com.springboot.assignmentapi.repos.ProfileRepo;
import com.springboot.assignmentapi.repos.VehicleRepo;
import com.springboot.assignmentapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CustomerController {

    @Autowired
    public CustomerService customerService;

    @Autowired
    public VehicleRepo vehicleRepo;

    @Autowired
    public ProfileRepo profileRepo;


    //Read Data
    @GetMapping("/api/get/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/api/getone/customer/{checkoutId}")
    public Map<String,Object> getIndividualCustomer(@PathVariable String checkoutId){
        Customer customerone = customerService.getIndividualCustomer(checkoutId);
        Map<String,Object> output= new HashMap<String,Object>();

        String resultId= customerone.getResultId();
        Profile profile=profileRepo.findProfileByResultId(resultId);
        String reqId= customerone.getRequestId();
        Vehicle vehicle=vehicleRepo.findByRequestId(reqId);

        output.put("customer", customerone);
        output.put("profile", profile);
        output.put("vehicle",vehicle);
        return output;
    }

   //Save Data
   @PostMapping("/new-api/customers")
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
