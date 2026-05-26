package com.SpringProject.airBnbApp.service;


import com.SpringProject.airBnbApp.entity.Inventory;
import com.SpringProject.airBnbApp.entity.Room;
import com.SpringProject.airBnbApp.repository.InventoryRepository;
import com.SpringProject.airBnbApp.entity.Hotel;
import com.SpringProject.airBnbApp.dto.HotelSearchRequest;
import com.SpringProject.airBnbApp.dto.HotelDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.data.domain.Page;
import java.time.temporal.ChronoUnit;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class InventoryServiceImpl implements InventoryService{

    private final ModelMapper modelMapper;
    private final InventoryRepository inventoryRepository;

    // InventoryServiceImpl(ModelMapper modelMapper) {
    //     this.modelMapper = modelMapper;
    // }

    @Override
    public void initializeRoomForAYear(Room room) {
        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusYears(1);
        for (; !today.isAfter(endDate); today=today.plusDays(1)) {
            Inventory inventory = Inventory.builder()
                    .hotel(room.getHotel())
                    .room(room)
                    .bookedCount(0)
                    .reservedCount(0)
                    .city(room.getHotel().getCity())
                    .date(today)
                    .price(room.getBasePrice())
                    .surgeFactor(BigDecimal.ONE)
                    .totalCount(room.getTotalCount())
                    .closed(false)
                    .build();
            inventoryRepository.save(inventory);
        }
    }

    @Override
    public void deleteAllInventories(Room room) {
        log.info("Deleting inventories for room {}", room.getId());
        inventoryRepository.deleteByRoom(room);
    }

    @Override
    public Page<HotelDto> searchHotels(HotelSearchRequest hotelSearchRequest) {
        log.info("Searching hotels for {} city, from {} to {}", hotelSearchRequest.getCity(), hotelSearchRequest.getCheckInDate(), hotelSearchRequest.getCheckOutDate());
        Pageable pageable = PageRequest.of(hotelSearchRequest.getPage(), hotelSearchRequest.getSize());
        long dateCount =  ChronoUnit.DAYS.between(
            hotelSearchRequest.getCheckInDate(),
            hotelSearchRequest.getCheckOutDate()
        ) + 1;

        Page<Hotel> hotelList = inventoryRepository.findHotelsWithAvailableInventory(
            hotelSearchRequest.getCity(),
            hotelSearchRequest.getCheckInDate(),
            hotelSearchRequest.getCheckOutDate(),
            hotelSearchRequest.getRoomsCount(),
            dateCount, pageable
        ); 
    
         return hotelList.map((element) -> modelMapper.map(element, HotelDto.class));
       
    }
}

