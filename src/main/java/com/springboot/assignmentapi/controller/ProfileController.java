package com.springboot.assignmentapi.controller;

import com.springboot.assignmentapi.model.Profile;
import com.springboot.assignmentapi.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("/api/get/profile/{requestId}")
    public List<Profile> getProfile(@PathVariable String requestId){
        return profileService.getProfile(requestId);
    }
}
