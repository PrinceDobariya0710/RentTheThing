package com.rent.project.authservice.controllers;

import com.rent.project.authservice.Util.JwtUtil;
import com.rent.project.authservice.models.AuthRequest;
import com.rent.project.authservice.models.UserCredentials;
import com.rent.project.authservice.repository.User_Credentials_Repository;
import com.rent.project.authservice.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

    @Autowired
    private User_Credentials_Repository userRepo;

    @Autowired
    private LoginService loginService;


    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody UserCredentials signUpRequest) {
        return loginService.userSignIn(signUpRequest);
    }

    @GetMapping("/user-cred-data/{userName}")//For ADMIN
    public UserCredentials getUserCredentialsData (@PathVariable String userName){
        return userRepo.findByUserName(userName);
     }

   @PostMapping("/login")
    public ResponseEntity<String> generateToken(@RequestBody AuthRequest authRequest, HttpServletResponse response) throws Exception {
       try {
           authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
       } catch (Exception ex) {
           throw new Exception("inavalid username/password");
       }
       String token_jwt = jwtUtil.generateToken(authRequest.getUserName());
       response.setHeader("access_token","Bearer "+token_jwt);
       return ResponseEntity.ok().body("You have logged in successfully with "+ authRequest.getUserName()+"\n Your authentication token is " +token_jwt);
   }



}
