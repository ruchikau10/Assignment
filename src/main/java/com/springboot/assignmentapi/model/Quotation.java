package com.springboot.assignmentapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Quotation")

public class Quotation {
    @Id
    private String requestId;

    private String vertical;

    private String vehiclemake;

    private String vehiclemodel;

    private SupportedInsurers supportedInsurers;


    public Quotation(String requestId, String vertical, String vehiclemake, String vehiclemodel, SupportedInsurers supportedInsurers) {
        this.requestId = requestId;
        this.vertical = vertical;
        this.vehiclemake = vehiclemake;
        this.vehiclemodel = vehiclemodel;
        this.supportedInsurers = supportedInsurers;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public String getVehiclemake() {
        return vehiclemake;
    }

    public void setVehiclemake(String vehiclemake) {
        this.vehiclemake = vehiclemake;
    }

    public String getVehiclemodel() {
        return vehiclemodel;
    }

    public void setVehiclemodel(String vehiclemodel) {
        this.vehiclemodel = vehiclemodel;
    }

    public SupportedInsurers getSupportedInsurers() {
        return supportedInsurers;
    }

    public void setSupportedInsurers(SupportedInsurers supportedInsurers) {
        this.supportedInsurers = supportedInsurers;
    }
}
