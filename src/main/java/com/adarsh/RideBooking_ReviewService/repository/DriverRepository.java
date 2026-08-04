package com.adarsh.RideBooking_ReviewService.repository;

import com.adarsh.RideBooking_ReviewService.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
    Driver findByIdAndLicenceNumber(Long id, String licenceNumber);
    List<Driver> findAllByIdIn(List<Long> driverIds);
}
