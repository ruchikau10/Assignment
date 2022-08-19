package com.springboot.assignmentapi.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Request")

public class Vehicle {
    @Id
    private String id;
    private String vertical;
    private String vehiclemake;
    private String vehiclemodel;
    private String requestId;

    public Vehicle(String id, String vertical, String vehiclemake, String vehiclemodel, String requestId) {
        this.id = id;
        this.vertical = vertical;
        this.vehiclemake = vehiclemake;
        this.vehiclemodel = vehiclemodel;
        this.requestId = requestId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
