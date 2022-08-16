package com.springboot.assignmentapi.service;

import com.springboot.assignmentapi.model.Profile;

import java.util.List;

public interface ProfileService {
    List<Profile> getProfile(String requestId);
}
