package com.adarsh.RideBooking_ReviewService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Driver extends BaseModel{

    @Column(nullable=false)
    private String name;

    @Column(unique = true)
    private String LicenceNumber;

    @Column(unique = true)
    private String mobileNumber;

    @OneToMany(mappedBy = "driver")                   // 1 driver can have many bookings
    private List<Booking> bookings= new ArrayList<>();



}
