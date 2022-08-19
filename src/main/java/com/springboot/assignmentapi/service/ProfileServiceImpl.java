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
import java.util.Random;

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
    public void generateProfile(Vehicle vehicle) {
    //  Vehicle vehicle = vehicleRepo.findByRequestId(requestId);

        String vertical = vehicle.getVertical();
        String make= vehicle.getVehiclemake();
        String model = vehicle.getVehiclemodel();
//        List<Quotation> quotationList = new ArrayList<>
//                (quotationRepo.findAllQuotationByVerticalAndMakeAndModel(vertical,make,model));
        List<Quotation> quotationList = new ArrayList<>();
        quotationList = quotationRepo.findAllByMakeAndModel(make,model);

          Profile profile= new Profile();
          for(int i=0;i<quotationList.size();i++){
            profile.setRequestId(vehicle.getRequestId());
            profile.setSupportedInsurers(quotationList.get(i).getSupportedInsurers());
            profile.setResultId(quotationList.get(i).getRequestId());
            profileRepo.save(profile);
        }
    }

//    @Override
//        Random random = new Random();
//        String resultId = String.valueOf(Math.abs(random.nextLong()))
    //     profile.setResultId(resultId);
//    public void generateProfile1(String requestId) {
//        // comment
//        Vehicle vehicle = vehicleRepo.findByRequestId(requestId);
//        String updateMake = vehicle.getVehiclemake();
//        String updateModel = vehicle.getVehiclemodel();
//        List<Quotation> quotationList = new ArrayList<>
//                (quotationRepo.findQuotationswithmakeandmodel(updateMake,updateModel));

//        Profile profile= new Profile();
//        for(int i=0;i<=quotationList.size();i++){
//            profile.setRequestId(requestId);   //make and model of vehicle
//            profile.setSupportedInsurers(quotationList.get(i).getSupportedInsurers());
//            profile.setResultId(quotationList.get(i).getRequestId());
//            profileRepo.save(profile);
//        }
//    }
}
