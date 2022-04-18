package com.rent.project.userprofileservice.controllers;


import com.rent.project.userprofileservice.formatedData.AddressRequest;
import com.rent.project.userprofileservice.formatedData.ContactRequest;
import com.rent.project.userprofileservice.formatedData.UserProfileData;
import com.rent.project.userprofileservice.models.AddressDetails;
import com.rent.project.userprofileservice.repositories.AddressDetailsRepo;
import com.rent.project.userprofileservice.formatedData.*;
import com.rent.project.userprofileservice.models.ContactDetails;
import com.rent.project.userprofileservice.models.State;
import com.rent.project.userprofileservice.models.UserDetails;
import com.rent.project.userprofileservice.repositories.ContactDetailsRepo;
import com.rent.project.userprofileservice.repositories.StatesRepo;
import com.rent.project.userprofileservice.repositories.UserDetailsRepo;
import com.rent.project.userprofileservice.services.AddressService;
import com.rent.project.userprofileservice.services.ContactService;
import com.rent.project.userprofileservice.services.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userdetail/user-profile-data")
public class UserDetailsController {

    @Autowired
    private UserDetailsRepo userDetailsRepo;

    @Autowired
    private StatesRepo statesRepo;

    @Autowired
    private AddressDetailsRepo addressDetailsRepo;

    @Autowired
    private ContactDetailsRepo contactDetailsRepo;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ContactService contactService;

    @GetMapping("/")
    public State states(){
        return statesRepo.findBystateName("Gujarat");
    }

    @PostMapping("/register/profiledata/")
    public ResponseEntity<String> postUserDetail(@RequestBody UserProfileData userProfileData){

        try{
            return userDetailsService.userProfile(userProfileData);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Can not insert user_profile data"+e);
        }
    }

    @PostMapping("/register/addressdata")
    public ResponseEntity<String> postAddressData(@RequestBody AddressRequest addressRequest){
        try {
            return addressService.userAddressPost(addressRequest);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Can not able to post address due to Exception \n" + e);
        }
    }

    @PostMapping("/register/contactdata")
    public ResponseEntity<String> postContactData(@RequestBody ContactRequest contactRequest){
        try {
            return contactService.userContactPost(contactRequest);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Can not able to post contact due to Exception \n" + e);
        }
    }

    @GetMapping("/get/profiledata/{userId}")
    public Optional<UserDetails> getProfileData(@PathVariable Long userId){
        return userDetailsRepo.findById(userId);
    }


    @GetMapping("/get/addressdata/{userDetailsId}")
    public ResponseEntity<List<AddressDetails>> getAddressData(@PathVariable Long userDetailsId){
        System.out.println(userDetailsId);
        List<AddressDetails> address = addressDetailsRepo.findByUserDetails(userDetailsId);
        Integer countA = address.size();
    return ResponseEntity.ok().body(address);
    }

    @GetMapping("/get/contactdata/{userDetailsId}")
    public List<ContactDetails> getContactData(@RequestBody ContactDetails contactDetails,@PathVariable Long userDetailsId){
        return contactDetailsRepo.findByuserDetailsId(userDetailsId);
    }

    @PutMapping("/put/contactdata/{userDetailsId}")
    public ResponseEntity<String> putContactData(@RequestBody ContactDetails contactDetails,@PathVariable Long userDetailsId){
            this.contactService.updateContact(contactDetails,userDetailsId);
            Object updatedcontact = contactDetailsRepo.save(contactDetails);
            return ResponseEntity.ok().body("Your contact is updated as : \n"+updatedcontact);
    }

    @PutMapping("/put/addressdata/{userDetailsId}")
    public ResponseEntity<String> putAddressData(@RequestBody AddressDetails addressDetails,@PathVariable Long userDetailsId){
        this.addressService.updateAddress(addressDetails,userDetailsId);
        Object updatedAddress = addressDetailsRepo.save(addressDetails);
        return ResponseEntity.ok().body("Your address is updated as : \n"+updatedAddress);
    }


}
