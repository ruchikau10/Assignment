package com.springboot.assignmentapi.model;

import org.springframework.data.annotation.Id;

public class SupportedInsurers {

    private String insurer_name;

    private int premium_amt;

    public SupportedInsurers(String insurer_id, String insurer_name, int premium_amt) {
        this.insurer_name = insurer_name;
        this.premium_amt = premium_amt;
    }

    public String getInsurer_name() {
        return insurer_name;
    }

    public void setInsurer_name(String insurer_name) {
        this.insurer_name = insurer_name;
    }

    public int getPremium_amt() {
        return premium_amt;
    }

    public void setPremium_amt(int premium_amt) {
        this.premium_amt = premium_amt;
    }
}
