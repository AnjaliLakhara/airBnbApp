package com.SpringProject.airBnbApp.repository;

import com.SpringProject.airBnbApp.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {

}

