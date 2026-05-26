package com.SpringProject.airBnbApp.controller;

import com.SpringProject.airBnbApp.dto.HotelDto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import com.SpringProject.airBnbApp.dto.HotelSearchRequest;
import com.SpringProject.airBnbApp.service.InventoryService;
import org.springframework.data.domain.Page;
import lombok.RequiredArgsConstructor;
import com.SpringProject.airBnbApp.dto.HotelInfoDto;
import com.SpringProject.airBnbApp.service.HotelService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/hotels")
@RequiredArgsConstructor
public class HotelBrowserController {
     
    private final InventoryService inventoryService;
    private final HotelService hotelService;
    
    @PostMapping("/search")
    public ResponseEntity<Page<HotelDto>> searchHotels(@RequestBody HotelSearchRequest hotelSearchRequest) {
        Page<HotelDto> hotels = inventoryService.searchHotels(hotelSearchRequest);
        return ResponseEntity.ok(hotels);
        
    }

    @GetMapping ("/{hotelId}/info")
    public ResponseEntity<HotelInfoDto> getHotelInfo(@PathVariable Long hotelId) {
        return ResponseEntity.ok(hotelService.getHotelInfoById(hotelId));  
    }
}
