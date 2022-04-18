package com.rent.project.userprofileservice.services;

import com.rent.project.userprofileservice.formatedData.AddressRequest;
import com.rent.project.userprofileservice.models.AddressDetails;
import com.rent.project.userprofileservice.repositories.AddressDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressDetailsRepo addressDetailsRepo;
    //Post service method for address
    public ResponseEntity<String> userAddressPost(AddressRequest addressRequest){
        AddressDetails userAddress = new AddressDetails(addressRequest.getUserDetailsId(),
                addressRequest.getFlatNo(),
                addressRequest.getStreet(),
                addressRequest.getLandmark(),
                addressRequest.getCity(),
                addressRequest.getState(),
                addressRequest.getCountry(),
                addressRequest.getPincode());
        AddressDetails address = addressDetailsRepo.save(userAddress);
        return ResponseEntity.ok("Your address details entered successfully" + address );
    }

    public void updateAddress(AddressDetails addressDetails, Long userDetailsId) {
        List<AddressDetails> address = addressDetailsRepo.findByUserDetails(userDetailsId);
        address.stream().map(b->{
            if(b.getUserDetails().getId()==userDetailsId){
                b.setFlatNo(addressDetails.getFlatNo());
                b.setStreet(addressDetails.getStreet());
                b.setLandmark(addressDetails.getLandmark());
                b.setCity(addressDetails.getCity());
                b.setState(addressDetails.getState());
                b.setCountry(addressDetails.getCountry());
                b.setPincode(addressDetails.getPincode());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
