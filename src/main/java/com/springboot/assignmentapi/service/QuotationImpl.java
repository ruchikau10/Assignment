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
        String requestId;
        while(true){
            Random random = new Random();
            requestId = String.valueOf(Math.abs(random.nextLong()));
            if(quotationRepo.findQuotationByRequestId(requestId)==null){
                break;
            }
        }
        quotation.setRequestId(requestId);
        quotationRepo.save(quotation);
        return  quotation.getRequestId();
    }

    @Override
    public List<Quotation> getOneQuotation(String requestId) {
        return quotationRepo.findAllQuotationByRequestId(requestId);
    }

    @Override
    public void deleteQuotation(String requestId){
        Quotation quotation = quotationRepo.findQuotationByRequestId(requestId);
        quotationRepo.delete(quotation);
    }

    @Override
    public Quotation updateQuotation(String requestId, Quotation quotation) {

        Quotation quotation1 =quotationRepo.findQuotationByRequestId(requestId);

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
