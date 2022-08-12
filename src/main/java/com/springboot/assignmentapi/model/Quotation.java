package com.springboot.assignmentapi.model;

import org.springframework.data.annotation.Id;

public class Quotation {
    @Id
    private String requestId;

    private String vehiclemake;
}
