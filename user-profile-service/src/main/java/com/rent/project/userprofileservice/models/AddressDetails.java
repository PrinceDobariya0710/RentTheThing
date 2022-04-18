package com.rent.project.userprofileservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "AddressDetails")
@Data
@Table
public class AddressDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(nullable = false)
    private UserDetails userDetails;

    @Column(nullable = false, length = 15) // name ="FlatNo",
    private String flatNo;

    @Column(nullable = false, length = 30) // name ="Street",
    private String street;

    @Column(nullable = false, length = 25) // name ="Landmark",
    private String landmark;

    @ManyToOne
    @JoinColumn(nullable = false, referencedColumnName = "id") //name ="City",
    private City city;

    @JoinColumn(nullable = false, referencedColumnName = "id") //name ="State",
    @ManyToOne
    private State state;

    @ManyToOne
    @JoinColumn(nullable = false, referencedColumnName = "id") //name ="CountryRef",
    private Country country;

    @Column(nullable = false, length = 8) // name = "Pincode",
    private Integer pincode;

    public AddressDetails(UserDetails userDetails, String flatNo, String street, String landmark, City city, State state, Country country, Integer pincode) {
        this.userDetails = userDetails;
        this.flatNo = flatNo;
        this.street = street;
        this.landmark = landmark;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }
}
