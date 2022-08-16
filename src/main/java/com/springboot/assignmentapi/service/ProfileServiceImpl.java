package com.springboot.assignmentapi.service;

import com.springboot.assignmentapi.model.Profile;
import com.springboot.assignmentapi.model.Quotation;
import com.springboot.assignmentapi.model.Vehicle;
import com.springboot.assignmentapi.repos.ProfileRepo;
import com.springboot.assignmentapi.repos.QuotationRepo;
import com.springboot.assignmentapi.repos.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    public QuotationRepo quotationRepo;
    @Autowired
    public VehicleRepo vehicleRepo;

    @Override
    public List<Profile> getProfile(String requestId) {
        return profileRepo.findAllByRequestId(requestId);
    }

    @Override
    public void generateProfile(String requestId) {
        Vehicle vehicle = vehicleRepo.findByRequestId(requestId);
        String updateMake = vehicle.getVehiclemake();
        String updateModel = vehicle.getVehiclemodel();
        List<Quotation> quotationList = new ArrayList<>
                (quotationRepo.findQuotationswithmakeandmodel(updateMake,updateModel));

        Profile profile= new Profile();
        for(int i=0;i<quotationList.size();i++){
            profile.setRequestId(requestId);   //make and model of vehicle
            profile.setSupportedInsurers(quotationList.get(i).getSupportedInsurers());
            profile.setResultId(quotationList.get(i).getRequestId());
            profileRepo.save(profile);
        }
    }

    @Override
    public void generateProfile1(String requestId) {
        // comment
        Vehicle vehicle = vehicleRepo.findByRequestId(requestId);
        String updateMake = vehicle.getVehiclemake();
        String updateModel = vehicle.getVehiclemodel();
        List<Quotation> quotationList = new ArrayList<>
                (quotationRepo.findQuotationswithmakeandmodel(updateMake,updateModel));

        Profile profile= new Profile();
        for(int i=0;i<=quotationList.size();i++){
            profile.setRequestId(requestId);   //make and model of vehicle
            profile.setSupportedInsurers(quotationList.get(i).getSupportedInsurers());
            profile.setResultId(quotationList.get(i).getRequestId());
            profileRepo.save(profile);
        }
    }
}
