package com.springboot.assignmentapi.service;

import com.springboot.assignmentapi.model.Profile;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProfileService {
    List<Profile> getProfile(String requestId);

    void generateProfile(String requestId);

    void generateProfile1(String requestId);
}
