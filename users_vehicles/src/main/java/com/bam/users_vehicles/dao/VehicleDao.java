package com.bam.users_vehicles.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bam.users_vehicles.entites.Vehicle;

public interface VehicleDao extends JpaRepository<Vehicle, Long> {

    Vehicle findByvName(String vName);

}
