package com.SpringProject.airBnbApp.repository;

import com.SpringProject.airBnbApp.entity.Inventory;
import com.SpringProject.airBnbApp.entity.Room;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;


public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    void deleteByDateAfterAndRoom( LocalDate date, Room room);
}
