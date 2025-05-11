package com.bam.tasks.dto;

public record ErrorResponse(int status,
        String messages,
        String details) {

}
