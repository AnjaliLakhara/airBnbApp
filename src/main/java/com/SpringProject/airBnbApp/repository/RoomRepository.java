package com.SpringProject.airBnbApp.repository;

import com.SpringProject.airBnbApp.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
