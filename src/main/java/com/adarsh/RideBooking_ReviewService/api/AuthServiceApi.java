package com.adarsh.RideBooking_ReviewService.api;

import com.adarsh.RideBooking_ReviewService.dtos.TokenValidationRequestDto;
import com.adarsh.RideBooking_ReviewService.dtos.TokenValidationResponseDto;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthServiceApi {
    @POST("/api/v1/auth/validate")
    Call<TokenValidationResponseDto> validateToken(
            @Body TokenValidationRequestDto requestDto
    );
}
