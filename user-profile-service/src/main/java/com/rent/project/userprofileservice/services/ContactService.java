package com.rent.project.userprofileservice.services;

import com.rent.project.userprofileservice.formatedData.ContactRequest;
import com.rent.project.userprofileservice.models.ContactDetails;
import com.rent.project.userprofileservice.repositories.ContactDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    @Autowired
    private ContactDetailsRepo contactDetailsRepo;
    //Post service method for contact
    public ResponseEntity<String> userContactPost(ContactRequest contactRequest) {
        try {
            ContactDetails userContact = new ContactDetails(contactRequest.getUserDetailsId(),
                    contactRequest.getPrimaryContact(),
                    contactRequest.getSecondaryContact());
            ContactDetails contact = contactDetailsRepo.save(userContact);
            return ResponseEntity.ok("Your contact details entered successfully" + contact);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("You already have contact. This error is due to Exception \n" + e);
        }

    }


    public void updateContact(ContactDetails contactDetails,Long userDetailsId){
        List<ContactDetails> contact = contactDetailsRepo.findByuserDetailsId(userDetailsId);
        contact.stream().map(b->{
                if(b.getUserDetails().getId()==userDetailsId){
                    b.setPrimaryContact(contactDetails.getPrimaryContact());
                    b.setSecondaryContact(contactDetails.getSecondaryContact());
                }
            return b;
        }).collect(Collectors.toList());
    }
}
