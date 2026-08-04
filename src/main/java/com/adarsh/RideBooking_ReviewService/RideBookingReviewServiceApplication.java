package com.adarsh.RideBooking_ReviewService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class RideBookingReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RideBookingReviewServiceApplication.class, args);
	}

}
