package com.adarsh.RideBooking_ReviewService.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="passenger_review")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PassengerReview extends Review{
  //passenger will give rating/review of driver

    @Column(nullable = false)
    private String passengerReviewContent;

    @Column(nullable = false)
    private Double passengerRating;
}
