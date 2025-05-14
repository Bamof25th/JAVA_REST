package com.bam.users_vehicles.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationRes {

    private LocalDateTime timestamp;
    private String message;

    public ApplicationRes(String message) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
    }

}
