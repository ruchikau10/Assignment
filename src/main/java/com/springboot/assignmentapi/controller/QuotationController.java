package com.springboot.assignmentapi.controller;

import com.springboot.assignmentapi.model.Quotation;
import com.springboot.assignmentapi.service.QuotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuotationController {

    @Autowired
    private QuotationService quotationService;

    @GetMapping("/api/get/quotation")
    public List<Quotation> getQuotation(){
        return quotationService.getQuotation();
    }

    @PostMapping("/api/add/quotation")
    public String addQuotation(@RequestBody Quotation quotation){
        String requestId = quotationService.addQuotation(quotation);
        return requestId;
    }

    @GetMapping("/api/get/quotation/{requestId}")
    public Quotation getOneQuotation(@PathVariable String requestId){
        return quotationService.getOneQuotation(requestId);
    }

    @PutMapping("/api/update/quotation/{requestId}")
    public Quotation updateQuotation(@RequestBody Quotation quotation, @PathVariable String requestId){
        return quotationService.updateQuotation(requestId, quotation);
    }

    //delete quotation
    @DeleteMapping("/api/delete/quotation/{requestId}")
    public void deleteQuotation(@PathVariable String requestId){
        quotationService.deleteQuotation(requestId);
    }

}
