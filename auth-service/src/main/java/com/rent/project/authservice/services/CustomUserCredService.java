package com.rent.project.authservice.services;

import com.rent.project.authservice.models.UserCredentials;
import com.rent.project.authservice.repository.User_Credentials_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomUserCredService implements UserDetailsService{

    @Autowired
    private User_Credentials_Repository userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserCredentials user = userRepo.findByUserName(username);
        List<SimpleGrantedAuthority> role = null;

        if(user!=null){
            List<String> roleInt = user.getRole();
            role = roleInt.stream().map( r -> new SimpleGrantedAuthority(r)).collect(Collectors.toList());
            return new User(user.getUserName(),user.getPassword(),role);
        }
        throw new UsernameNotFoundException("User not found with the name " + username);

    }


}
