package com.bam.users_vehicles.controllers;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bam.users_vehicles.dto.VehicleDto;
import com.bam.users_vehicles.services.VehicleService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/{user_id}/vehicle")
public class VehicleController {

    // private final ModelMapper modelMapper;
    private final VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<?> getMethodName(@PathVariable("user_id") Long userId) {
        return ResponseEntity.ok(vehicleService.getAllVehicle(userId));
    }

    @PostMapping
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDto vehicleDto, @PathVariable("user_id") Long uid) {
        return ResponseEntity.ok(vehicleService.createVehicle(vehicleDto, uid));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteVehicle(@PathVariable("user_id") Long uid, @PathVariable("vehicle_id") Long vid) {
        return ResponseEntity.ok(vehicleService.deleteVehicle(uid, vid));
    }

    @PostMapping("/get-sold-vehicles")
    public ResponseEntity<?> getSoldVehicles(@RequestBody LocalDate date) {
        return ResponseEntity.ok(vehicleService.getSoldVehiclesByDate(date));

    }

}
