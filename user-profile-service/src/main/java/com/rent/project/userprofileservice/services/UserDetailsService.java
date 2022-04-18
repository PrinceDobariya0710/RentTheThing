package com.rent.project.userprofileservice.services;

import com.rent.project.userprofileservice.formatedData.UserProfileData;
import com.rent.project.userprofileservice.models.UserDetails;
import com.rent.project.userprofileservice.models.*;
import com.rent.project.userprofileservice.repositories.CityRepo;
import com.rent.project.userprofileservice.repositories.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {
    @Autowired
    private UserDetailsRepo userDetailsRepo;





    @Autowired
    private CityRepo cityRepo;

    //UserDetailsService to fill user details
    public ResponseEntity<String> userProfile(UserProfileData userProfileData) {
        System.out.println(userProfileData);
        UserDetails userDetails = new UserDetails(userProfileData.getUserId(),
                                                  userProfileData.getFirstName(),
                                                  userProfileData.getLastName(),
                                                  userProfileData.getDob(),
                                                  userProfileData.getOrgName(),
                                                  userProfileData.getWebsite());
        UserDetails userDetailsSaved = userDetailsRepo.save(userDetails);
        return ResponseEntity.ok("Your details entered successfully" + userDetailsSaved );
    }

}
