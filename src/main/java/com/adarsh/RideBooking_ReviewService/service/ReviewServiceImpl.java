package com.adarsh.RideBooking_ReviewService.service;

import com.adarsh.RideBooking_ReviewService.model.Booking;
import com.adarsh.RideBooking_ReviewService.model.Review;
import com.adarsh.RideBooking_ReviewService.repository.BookingRepository;
import com.adarsh.RideBooking_ReviewService.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review findReviewById(Long id)  {
        return reviewRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("review-id :"+id+" not found"));
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public  boolean deleteReviewById(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("review-id :"+id+" not found"));

        if(review.getId() != null) {
            reviewRepository.delete(review);
            return true;
        }
        return false;
    }

    @Override
    public Review publishReview(Review review)  {
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id, Review newReview) {
        Review review = reviewRepository.findById(id).orElseThrow(
                        ()->new EntityNotFoundException("review-id :"+id+" not found"));

        if(newReview.getContent()!=null){
            review.setContent(newReview.getContent());
        }
        if(newReview.getRating()!=null){
            review.setRating(newReview.getRating());
        }
        return reviewRepository.save(review);
    }
}
