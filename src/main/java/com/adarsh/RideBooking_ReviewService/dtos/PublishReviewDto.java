package com.adarsh.RideBooking_ReviewService.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublishReviewDto {
    private String content;
    private Double rating;
    private Long bookingId;
}
