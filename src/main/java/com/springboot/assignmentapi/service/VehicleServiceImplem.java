package com.springboot.assignmentapi.service;

import com.springboot.assignmentapi.model.Profile;
import com.springboot.assignmentapi.model.Vehicle;
import com.springboot.assignmentapi.repos.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Service
public class VehicleServiceImplem implements VehicleService{

    @Autowired
    public VehicleRepo vehicleRepo;

    @Autowired
    public ProfileService profileService;


   @Override
    public List<Vehicle> getVehicle(){
       return vehicleRepo.findAll();
   }

    @Override
    public Vehicle getVehicleByRequestid(String requestId) {

       return vehicleRepo.findByRequestId(requestId);
    }

    @Override
    public String addVehicle(Vehicle vehicle){
       Random random = new Random();
       String requestId = String.valueOf(Math.abs(random.nextLong()));
       vehicle.setRequestId(requestId);
       vehicleRepo.save(vehicle);
       profileService.generateProfile(requestId);
       return requestId;
   }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle, String requestId) {
       Vehicle vehicle1 = vehicleRepo.findById(requestId).get();

        if(Objects.nonNull(vehicle1.getVertical()) && !"".equalsIgnoreCase(vehicle.getVertical())){
            vehicle1.setVertical(vehicle.getVertical());
        }

        if(Objects.nonNull(vehicle1.getVehiclemake())&&!"".equalsIgnoreCase(vehicle.getVehiclemake())){
            vehicle1.setVehiclemake(vehicle.getVehiclemake());
        }

        if (Objects.nonNull(vehicle1.getVehiclemodel())&&!"".equalsIgnoreCase(vehicle.getVehiclemodel())){
            vehicle1.setVehiclemodel(vehicle.getVehiclemodel());
        }
        return vehicleRepo.save(vehicle1);
    }

    @Override
    public void deleteVehicle(String requestId) {
        Vehicle vehicle = vehicleRepo.findByRequestId(requestId);
        vehicleRepo.delete(vehicle);
    }
}
