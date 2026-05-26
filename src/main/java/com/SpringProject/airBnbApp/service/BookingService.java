package com.SpringProject.airBnbApp.service;

import java.util.List;

import com.SpringProject.airBnbApp.dto.BookingDto;
import com.SpringProject.airBnbApp.dto.BookingRequest;
import com.SpringProject.airBnbApp.dto.GuestDto;
public interface BookingService {

    BookingDto initializeBooking(BookingRequest request);
    BookingDto addGuests(Long bookingId, List<GuestDto> guestDtoList);
}
