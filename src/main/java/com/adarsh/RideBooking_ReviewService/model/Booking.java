package com.adarsh.RideBooking_ReviewService.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","driver","passenger"})
public class Booking extends BaseModel {

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    private Long distance;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    private Passenger passenger;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
}
