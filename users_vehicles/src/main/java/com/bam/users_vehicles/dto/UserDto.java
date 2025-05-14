package com.bam.users_vehicles.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class UserDto {
    private String uname;

    private String email;

    private String password;

    private String city;

    private String contactNo;

    private LocalDate dob;
}
