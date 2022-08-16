package com.springboot.assignmentapi.service;

import com.springboot.assignmentapi.model.Quotation;

import java.util.List;

public interface QuotationService {

    List<Quotation> getQuotation();

    String addQuotation(Quotation quotation);

    Quotation getOneQuotation(String requestId);

    void deleteQuotation(String requestId);

    Quotation updateQuotation(String requestId, Quotation quotation);
}
