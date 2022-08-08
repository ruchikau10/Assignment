package com.springboot.assignmentapi.model;

import org.springframework.data.annotation.Id;

public class Vehicle {
    @Id
    private String requestId;

    private String verticalmake;

    private String verticalmodel;

    private String vertical;

    public Vehicle(String vertical, String verticalmake, String verticalmodel, String requestId) {
        this.vertical = vertical;
        this.verticalmake = verticalmake;
        this.verticalmodel = verticalmodel;
        this.requestId = requestId;
    }

    public String getVertical() {
        return vertical;
    }

    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

    public String getVerticalmake() {
        return verticalmake;
    }

    public void setVerticalmake(String verticalmake) {
        this.verticalmake = verticalmake;
    }

    public String getVerticalmodel() {
        return verticalmodel;
    }

    public void setVerticalmodel(String verticalmodel) {
        this.verticalmodel = verticalmodel;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
