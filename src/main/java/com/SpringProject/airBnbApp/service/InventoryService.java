package com.SpringProject.airBnbApp.service;
import com.SpringProject.airBnbApp.entity.Room;

public interface InventoryService {
    void initializeRoomForAYear(Room room);
    void deleteFutureInventories(Room room);
    
}
