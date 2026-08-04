package com.adarsh.RideBooking_ReviewService.controller;

import com.adarsh.RideBooking_ReviewService.adapter.PublishReviewDtoToReview;
import com.adarsh.RideBooking_ReviewService.dtos.PublishReviewDto;
import com.adarsh.RideBooking_ReviewService.dtos.ReviewDto;
import com.adarsh.RideBooking_ReviewService.model.Review;
import com.adarsh.RideBooking_ReviewService.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final PublishReviewDtoToReview publishReviewDtoToReview;

    @PostMapping
    public ResponseEntity<?> publishReview( @RequestBody PublishReviewDto publishReviewDto) throws Exception {
        Review incomingReview = publishReviewDtoToReview.toDto(publishReviewDto);
        if(incomingReview == null){
            return new ResponseEntity<>("Invalid argument...",HttpStatus.BAD_REQUEST);
        }

        reviewService.publishReview(incomingReview);

        ReviewDto response =  new ReviewDto();
        response.setReviewId(incomingReview.getId());
        response.setContent(incomingReview.getContent());
        response.setRating(incomingReview.getRating());
        response.setCreatedAt(incomingReview.getCreatedAt());
        response.setUpdatedAt(incomingReview.getUpdatedAt());
        response.setBookingId(incomingReview.getBooking().getId());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReviewById( @PathVariable Long id) {
        try{
            Review review = reviewService.findReviewById(id);
            return new ResponseEntity<>(review, HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllReviews() {
        List<Review> reviews = reviewService.findAllReviews();
        return new  ResponseEntity<>(reviews, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateReview( @PathVariable Long id, @RequestBody Review reviewRequest) {
        try{
            Review review = reviewService.updateReview(id, reviewRequest);
            return new ResponseEntity<>(review, HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReviewById(@PathVariable Long id) {
        try{
            boolean isDeleted = reviewService.deleteReviewById(id);
            if(!isDeleted) {
                return new ResponseEntity<>("Unable to delete review", HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
