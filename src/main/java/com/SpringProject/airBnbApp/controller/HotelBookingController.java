package com.SpringProject.airBnbApp.controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.SpringProject.airBnbApp.dto.GuestDto;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.SpringProject.airBnbApp.service.BookingService;
import org.springframework.http.ResponseEntity;
import com.SpringProject.airBnbApp.dto.BookingDto;
import com.SpringProject.airBnbApp.dto.BookingRequest;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class HotelBookingController {
   
    private final BookingService bookingService;
    
    @PostMapping("/init")
    public ResponseEntity<BookingDto> initializeBooking(@RequestBody BookingRequest bookingRequest) {
        return ResponseEntity.ok(bookingService.initializeBooking(bookingRequest));
    }

    @PostMapping("/{bookingId}/addGuests")
public ResponseEntity<BookingDto> addGuests(@PathVariable Long bookingId, @RequestBody List<GuestDto> guestDtoList) {
    return ResponseEntity.ok(bookingService.addGuests(bookingId, guestDtoList));
}
    

    
}
