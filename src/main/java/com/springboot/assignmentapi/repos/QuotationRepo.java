package com.springboot.assignmentapi.repos;

import com.springboot.assignmentapi.model.Quotation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuotationRepo extends MongoRepository<Quotation,String> {

    //custom query for make and model


    @Query("{requestId:?0}")
    Quotation findQuotationByRequestId(String requestId);

    @Query("{requestId:?0}")
    List<Quotation> findAllQuotationByRequestId(String requestId);

    @Query("{vehiclemake:?0,vehiclemodel:?1}")
    List<Quotation> findQuotationswithmakeandmodel(@Param("VehicleMake") String vehiclemake,@Param("VehicleMake") String vehiclemodel);
}
