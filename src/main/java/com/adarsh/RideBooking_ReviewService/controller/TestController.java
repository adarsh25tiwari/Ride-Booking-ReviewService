package com.adarsh.RideBooking_ReviewService.controller;

import com.adarsh.RideBooking_ReviewService.api.BookingServiceApi;
import com.adarsh.RideBooking_ReviewService.dtos.TokenValidationResponseDto;
import com.adarsh.RideBooking_ReviewService.dtos.UpdateBookingResponseDto;
import com.adarsh.RideBooking_ReviewService.service.AuthService;
import org.springframework.web.bind.annotation.*;
import retrofit2.Response;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    private final AuthService authService;
    private final BookingServiceApi bookingServiceApi;

    public TestController(AuthService authService, BookingServiceApi bookingServiceApi) {
        this.authService = authService;
        this.bookingServiceApi = bookingServiceApi;
    }


    @PostMapping("/validate")
    public TokenValidationResponseDto validate(
            @RequestHeader("Authorization") String authorization) {

        String token = authorization.replace("Bearer ", "");

        return authService.validateToken(token);
    }


    @GetMapping("/booking/{bookingId}")
    public UpdateBookingResponseDto getBooking(@PathVariable Long bookingId) {
        try {
            Response<UpdateBookingResponseDto> response =
                    bookingServiceApi.getBooking(bookingId).execute();

            if (!response.isSuccessful() || response.body() == null) {
                throw new RuntimeException("Booking Service request failed");
            }

            return response.body();

        } catch (IOException e) {
            throw new RuntimeException("Booking Service unavailable", e);
        }
    }
}
