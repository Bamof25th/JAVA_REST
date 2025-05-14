package com.bam.users_vehicles.services;

import java.time.LocalDate;
import java.util.List;

import com.bam.users_vehicles.dto.ApplicationRes;
import com.bam.users_vehicles.dto.VehicleDto;

public interface VehicleService {
    // Add new Vehicle
    ApplicationRes createVehicle(VehicleDto vehicleDto, Long userId);

    // Get All vehicles
    List<VehicleDto> getAllVehicle(Long userId);

    // Delete vehicles
    ApplicationRes deleteVehicle(Long vId, Long userId);

    // Get sold vehicles and user names by date
    List<VehicleDto> getSoldVehiclesByDate(LocalDate date);
}
