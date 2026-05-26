package com.SpringProject.airBnbApp.dto;


import com.SpringProject.airBnbApp.entity.User;
import com.SpringProject.airBnbApp.entity.enums.Gender;

import lombok.Data;

@Data
public class GuestDto {
    private Long id;
    private User user;
    private String name;
    private Integer age;
    private Gender gender;

}
