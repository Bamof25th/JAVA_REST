package com.bam.users_vehicles.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BuyDateDto {
    private String uName;
    private String vName;
    private LocalDateTime date;
}
