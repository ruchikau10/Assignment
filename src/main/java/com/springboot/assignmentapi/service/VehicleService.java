package com.springboot.assignmentapi.service;

import com.springboot.assignmentapi.model.Vehicle;

import java.util.List;

public interface VehicleService {

    List<Vehicle> getVehicle();

    Vehicle getVehicleByRequestid(String requestId);

    String addVehicle(Vehicle vehicle);

    Vehicle updateVehicle(Vehicle vehicle, String requestId);

    void deleteVehicle(String requestId);
}
