package com.springboot.assignmentapi.service;

import com.springboot.assignmentapi.model.Profile;
import com.springboot.assignmentapi.repos.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepo profileRepo;

    @Override
    public List<Profile> getProfile(String requestId) {
        return profileRepo.findByRequestId(requestId);
    }
}
