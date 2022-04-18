package com.rent.project.userprofileservice.formatedData;

import com.rent.project.userprofileservice.models.UserDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ContactRequest implements Serializable {

    private UserDetails userDetailsId;

    private Long primaryContact;

    private Long secondaryContact;
}
