package com.SpringProject.airBnbApp.service;

import com.SpringProject.airBnbApp.entity.Room;
import com.SpringProject.airBnbApp.dto.HotelDto;
import com.SpringProject.airBnbApp.dto.HotelSearchRequest;
import org.springframework.data.domain.Page;

public interface InventoryService {
    void initializeRoomForAYear(Room room);

    void deleteAllInventories(Room room);

    Page<HotelDto> searchHotels(HotelSearchRequest hotelSearchRequest);

}
