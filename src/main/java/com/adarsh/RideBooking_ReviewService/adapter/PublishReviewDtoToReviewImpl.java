package com.adarsh.RideBooking_ReviewService.adapter;

import com.adarsh.RideBooking_ReviewService.dtos.PublishReviewDto;
import com.adarsh.RideBooking_ReviewService.model.Booking;
import com.adarsh.RideBooking_ReviewService.model.Review;
import com.adarsh.RideBooking_ReviewService.repository.BookingRepository;
import org.springframework.stereotype.Component;
@Component
public class PublishReviewDtoToReviewImpl implements PublishReviewDtoToReview {

    @Override
    public Review toDto(PublishReviewDto dto) {

        Review review = new Review();

        review.setContent(dto.getContent());
        review.setRating(dto.getRating());
        review.setBookingId(dto.getBookingId());

        return review;
    }
}
