package com.springboot.assignmentapi.service;

import com.springboot.assignmentapi.model.Quotation;
import com.springboot.assignmentapi.repos.QuotationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class QuotationImpl implements  QuotationService{

    @Autowired
    private QuotationRepo quotationRepo;


    @Override
    public List<Quotation> getQuotation() {
        return quotationRepo.findAll();
    }

    @Override
    public String addQuotation(Quotation quotation) {
        Random random = new Random();
        String requestId = String.valueOf(Math.abs(random.nextLong()));
        quotation.getRequestId();
        quotationRepo.save(quotation);
        return requestId;
    }

    @Override
    public Quotation getOneQuotation(String requestId) {
        return quotationRepo.findQuotationById(requestId);
    }

    @Override
    public void deleteQuotation(String requestId){
        Quotation quotation = quotationRepo.findQuotationById(requestId);
        quotationRepo.delete(quotation);
    }

    @Override
    public Quotation updateQuotation(String requestId, Quotation quotation) {

        Quotation quotation1 =quotationRepo.findQuotationById(requestId);

        if(Objects.nonNull(quotation.getRequestId())&&"".equalsIgnoreCase(quotation.getRequestId())){
            quotation1.setRequestId(quotation.getRequestId());
        }

        if(Objects.nonNull(quotation.getVertical())&&"".equalsIgnoreCase(quotation.getVertical())){
            quotation1.setVertical(quotation.getVertical());
        }

        if(Objects.nonNull(quotation.getVehiclemake())&&"".equalsIgnoreCase(quotation.getVehiclemake())){
            quotation1.setVehiclemake(quotation.getVehiclemake());
        }

        if(Objects.nonNull(quotation.getVehiclemodel())&&"".equalsIgnoreCase(quotation.getVehiclemodel())){
            quotation1.setVehiclemodel(quotation.getVehiclemodel());
        }

        return quotation1;
    }
}
