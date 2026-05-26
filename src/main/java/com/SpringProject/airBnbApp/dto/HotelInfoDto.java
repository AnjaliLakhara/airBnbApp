package com.SpringProject.airBnbApp.dto;
import java.util.List;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class HotelInfoDto {
   private HotelDto hotel;
   private List<RoomDto> rooms;
}

