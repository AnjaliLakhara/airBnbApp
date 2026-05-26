package com.SpringProject.airBnbApp.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.Data;

@Data
public class BookingDto {
    
    private Long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer roomsCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String bookingStatus;
    private Set<GuestDto> guests;
    
}
