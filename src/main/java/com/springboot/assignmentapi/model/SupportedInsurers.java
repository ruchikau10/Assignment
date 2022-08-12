package com.springboot.assignmentapi.model;

import org.springframework.data.annotation.Id;

public class SupportedInsurers {
    @Id
    private String insurer_id;

    private String insurer_name;

    private int premium_amt;

    public SupportedInsurers(String insurer_id, String insurer_name, int premium_amt) {
        this.insurer_id = insurer_id;
        this.insurer_name = insurer_name;
        this.premium_amt = premium_amt;
    }

    public String getInsurer_id() {
        return insurer_id;
    }

    public void setInsurer_id(String insurer_id) {
        this.insurer_id = insurer_id;
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
