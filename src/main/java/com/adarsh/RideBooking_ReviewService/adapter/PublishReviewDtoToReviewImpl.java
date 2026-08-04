package com.adarsh.RideBooking_ReviewService.adapter;

import com.adarsh.RideBooking_ReviewService.dtos.PublishReviewDto;
import com.adarsh.RideBooking_ReviewService.model.Booking;
import com.adarsh.RideBooking_ReviewService.model.Review;
import com.adarsh.RideBooking_ReviewService.repository.BookingRepository;
import org.springframework.stereotype.Component;

@Component
public class PublishReviewDtoToReviewImpl implements PublishReviewDtoToReview {

    private BookingRepository bookingRepository;
    public PublishReviewDtoToReviewImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Review toDto(PublishReviewDto dto) {

        Booking booking = bookingRepository.findById(dto.getBookingId()).orElseThrow(
                () -> new RuntimeException("booking id not found"));

        Review review = new Review();
        review.setContent(dto.getContent());
        review.setRating(dto.getRating());
        review.setBooking(booking);

        return review;
    }
}
