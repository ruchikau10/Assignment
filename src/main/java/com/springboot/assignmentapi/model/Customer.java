package com.springboot.assignmentapi.model;

import org.springframework.data.annotation.Id;

public class Customer {
    @Id
    private String checkoutId;

    private String customerEmail;

    private String customerPhoneNo;

    private String  customerName;

    private String requestId;

    public Customer(String checkoutId, String customerEmail, String customerPhoneNo, String customerName, String requestId) {
        this.checkoutId = checkoutId;
        this.customerEmail = customerEmail;
        this.customerPhoneNo = customerPhoneNo;
        this.customerName = customerName;
        this.requestId = requestId;
    }

    public String getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(String checkoutId) {
        this.checkoutId = checkoutId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhoneNo() {
        return customerPhoneNo;
    }

    public void setCustomerPhoneNo(String customerPhoneNo) {
        this.customerPhoneNo = customerPhoneNo;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
