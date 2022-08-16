package com.springboot.assignmentapi.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Response")

public class Profile {

    private String requestId;

    private String resultId;

    private SupportedInsurers supportedInsurers;

    public Profile() {
    }

    public Profile(String requestId, String resultId, SupportedInsurers supportedInsurers) {
        this.requestId = requestId;
        this.resultId = resultId;
        this.supportedInsurers = supportedInsurers;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public SupportedInsurers getSupportedInsurers() {
        return supportedInsurers;
    }

    public void setSupportedInsurers(SupportedInsurers supportedInsurers) {
        this.supportedInsurers = supportedInsurers;
    }
}
