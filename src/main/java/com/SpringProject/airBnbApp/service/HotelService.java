package com.SpringProject.airBnbApp.service;
import com.SpringProject.airBnbApp.dto.HotelDto;
import com.SpringProject.airBnbApp.dto.HotelInfoDto;


public interface HotelService {

    HotelDto createNewHotel(HotelDto hotelDto);
     
    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long id, HotelDto hotelDto);

    void deleteHotelById(Long id);

    void activateHotel(Long id);

      HotelInfoDto getHotelInfoById(Long hotelId);
}
