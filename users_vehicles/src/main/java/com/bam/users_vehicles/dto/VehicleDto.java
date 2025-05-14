package com.bam.users_vehicles.dto;

import java.time.LocalDate;

import com.bam.users_vehicles.entites.Company;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class VehicleDto {
    private String vName;
    private String vNumber;
    private Company company;
    private String vType;
    private LocalDate purchaseDate;
    private String userName;
}
