package com.adarsh.RideBooking_ReviewService.service;

import com.adarsh.RideBooking_ReviewService.api.AuthServiceApi;
import com.adarsh.RideBooking_ReviewService.dtos.TokenValidationRequestDto;
import com.adarsh.RideBooking_ReviewService.dtos.TokenValidationResponseDto;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Service
public class AuthService {
    private final AuthServiceApi authServiceApi;

    public AuthService(AuthServiceApi authServiceApi) {
        this.authServiceApi = authServiceApi;
    }

    public TokenValidationResponseDto validateToken(String token) {

        TokenValidationRequestDto request = new TokenValidationRequestDto(token);
        try {
            Call<TokenValidationResponseDto> call = authServiceApi.validateToken(request);
            Response<TokenValidationResponseDto> response = call.execute();

            if (!response.isSuccessful() || response.body() == null) {
                throw new RuntimeException("Token validation failed");
            }
            return response.body();

        } catch (IOException e) {
            throw new RuntimeException("Auth Service unavailable", e);
        }
    }
}
