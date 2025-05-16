package com.cdac.dto;

import com.cdac.entity.SportType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDto {
    private String playerName;
    private SportType sportType;
    private String contact;
    private String email;
    private String address;
    private Integer sportsPoints;
}
