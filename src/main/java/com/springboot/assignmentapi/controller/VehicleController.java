package com.springboot.assignmentapi.controller;

import com.springboot.assignmentapi.model.Vehicle;
import com.springboot.assignmentapi.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    public VehicleService vehicleService;

    @GetMapping("/api/get/vehicle")
    public List<Vehicle> getVehicle(){
        return vehicleService.getVehicle();
    }

    @GetMapping("/api/get/vehicle/{requestId}")
    public Vehicle getVehicleByRequestid(@PathVariable ("requestId") String requestId){
        return vehicleService.getVehicleByRequestid(requestId);
    }

    @PostMapping("/api/add/vehicle")
    public String addVehicle(@RequestBody Vehicle vehicle){
        String requestId = vehicleService.addVehicle(vehicle);
        return requestId;
    }

    @PutMapping("/api/update/vehicle/{requestId}")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle,@PathVariable ("requestId") String requestId){
       return vehicleService.updateVehicle(vehicle, requestId);
    }

    @DeleteMapping("/api/delete/vehicle/{requestId}")
    public void deleteVehicle(@PathVariable ("requestId") String requestId){
        vehicleService.deleteVehicle(requestId);
    }


}
