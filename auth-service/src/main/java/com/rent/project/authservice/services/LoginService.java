package com.rent.project.authservice.services;

import com.rent.project.authservice.models.UserCredentials;
import com.rent.project.authservice.repository.User_Credentials_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private User_Credentials_Repository userRepo;

    @Autowired
    private PasswordEncoder encoder;

    //Login Service
    public ResponseEntity<String> userSignIn(UserCredentials signUpRequest) {
        if (userRepo.existsByUserName(signUpRequest.getUserName())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }
        if (userRepo.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already in use!");
        }
        UserCredentials user;
        if (signUpRequest.getRole().get(0).equals("USER")) {
            String password = signUpRequest.getPassword();
            String p=encoder.encode(password);
            signUpRequest.setPassword(p);
            user = userRepo.save(signUpRequest);
        } else {
            return ResponseEntity.badRequest().body("Error : UserRole is undefined");
        }
        // Create new user's account
        return ResponseEntity.ok().body("User registered with " +
                user.getUserName() +" and " + user.getEmail() +
                " done successfully! at " + user.getCreatedAt());
    }
}
