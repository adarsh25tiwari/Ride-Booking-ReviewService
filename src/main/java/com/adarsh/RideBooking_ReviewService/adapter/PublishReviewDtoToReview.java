package com.adarsh.RideBooking_ReviewService.adapter;

import com.adarsh.RideBooking_ReviewService.dtos.PublishReviewDto;
import com.adarsh.RideBooking_ReviewService.model.Review;

public interface PublishReviewDtoToReview {
    public Review toDto(PublishReviewDto dto);  //convert publishReviewDto to Review object
}
