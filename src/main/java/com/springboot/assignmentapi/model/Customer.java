package com.springboot.assignmentapi.model;

import org.springframework.data.annotation.Id;

public class Customer {
    @Id
    private String checkoutId;

    private String customerEmail;

    private Integer customerPhoneNo;

    private String  customerName;

    private String requestId;

    public Customer(String customerName, String customerEmail, Integer customePhoneNo, String checkoutId, String requestId) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNo = customePhoneNo;
        this.checkoutId = checkoutId;
        this.requestId = requestId;
    }

    public Integer getCustomerPhoneNo() {
        return customerPhoneNo;
    }

    public void setCustomerPhoneNo(Integer customePhoneNo) {
        this.customerPhoneNo = customePhoneNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(String checkoutId) {
        this.checkoutId = checkoutId;
    }

}
