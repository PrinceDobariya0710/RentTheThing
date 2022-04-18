package com.rent.project.userprofileservice.formatedData;

import com.rent.project.userprofileservice.models.AddressDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AddressResponse extends AddressDetails implements Serializable {
     private Integer countA;
}
