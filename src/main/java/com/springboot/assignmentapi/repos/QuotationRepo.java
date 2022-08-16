package com.springboot.assignmentapi.repos;

import com.springboot.assignmentapi.model.Quotation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface QuotationRepo extends MongoRepository<Quotation,String> {

    //custom query for make and model
    @Query("{requestId:?0}")
    Quotation findQuotationById(String requestId);

}
