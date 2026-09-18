package com.adarsh.RideBooking_ReviewService.controller;

import com.adarsh.RideBooking_ReviewService.dtos.TokenValidationResponseDto;
import com.adarsh.RideBooking_ReviewService.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    private final AuthService authService;

    public TestController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/validate")
    public TokenValidationResponseDto validate(
            @RequestHeader("Authorization") String authorization) {

        String token = authorization.replace("Bearer ", "");

        return authService.validateToken(token);
    }
}
