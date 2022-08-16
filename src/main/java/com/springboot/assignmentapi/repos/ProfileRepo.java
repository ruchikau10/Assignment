package com.springboot.assignmentapi.repos;

import com.springboot.assignmentapi.model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProfileRepo extends MongoRepository<Profile,String> {

    @Query("{requestId}:?0")
    List<Profile> findByRequestId(String requestId);

}
