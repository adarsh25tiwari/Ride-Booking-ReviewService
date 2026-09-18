package com.adarsh.RideBooking_ReviewService.configuration;

import com.adarsh.RideBooking_ReviewService.api.AuthServiceApi;
import com.adarsh.RideBooking_ReviewService.api.BookingServiceApi;
import com.netflix.discovery.EurekaClient;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class RetrofitConfig {

    private final EurekaClient eurekaClient;

    public RetrofitConfig(EurekaClient eurekaClient) {
        this.eurekaClient = eurekaClient;
    }

    private String getServiceUrl(String serviceName) {
        return eurekaClient
                .getNextServerFromEureka(serviceName, false)
                .getHomePageUrl();
    }

    @Bean
    public AuthServiceApi authServiceApi() {

        return new Retrofit.Builder()
                .baseUrl(getServiceUrl("RIDEBOOKING-AUTHSERVICE"))
                .addConverterFactory(JacksonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build()
                .create(AuthServiceApi.class);
    }

    @Bean
    public BookingServiceApi bookingServiceApi() {

        return new Retrofit.Builder()
                .baseUrl(getServiceUrl("RIDEBOOKING-BOOKINGSERVICE"))
                .addConverterFactory(JacksonConverterFactory.create())
                .client(new OkHttpClient.Builder().build())
                .build()
                .create(BookingServiceApi.class);
    }
}