package com.SpringProject.airBnbApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.SpringProject.airBnbApp.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>{

}
