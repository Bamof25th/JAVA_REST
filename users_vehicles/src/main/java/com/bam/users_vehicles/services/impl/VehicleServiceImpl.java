package com.bam.users_vehicles.services.impl;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bam.users_vehicles.dao.UserDao;
import com.bam.users_vehicles.dao.VehicleDao;
import com.bam.users_vehicles.dto.ApplicationRes;
import com.bam.users_vehicles.dto.VehicleDto;
import com.bam.users_vehicles.entites.User;
import com.bam.users_vehicles.entites.Vehicle;
import com.bam.users_vehicles.services.VehicleService;
import com.bam.users_vehicles.utils.ApplicationException;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Transactional
public class VehicleServiceImpl implements VehicleService {

    private final ModelMapper modelMapper;
    private final VehicleDao vehicleDao;
    private final UserDao userDao;

    @Override
    public ApplicationRes createVehicle(VehicleDto vehicleDto, Long userId) {

        if (null == vehicleDao.findByvName(vehicleDto.getVName())) {
            throw new ApplicationException("Vehicle name Already exists");
        }

        User user = userDao.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("No user with this id!!!"));

        Vehicle vehicle = modelMapper.map(vehicleDto, Vehicle.class);
        user.addVehicle(vehicle);
        userDao.save(user); // Explicitly save the user to ensure persistence

        return new ApplicationRes("Vehicle added Successfully");
    }

    @Override
    public ApplicationRes deleteVehicle(Long vId, Long userId) {

        User user = userDao.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("No user with this id!!!"));
        Vehicle v = vehicleDao.findById(vId).orElseThrow(
                () -> new IllegalArgumentException("Unable to find any vehicle with this ID"));
        // establish bi dir also between User 1 <---> * Vehicles
        user.addVehicle(v);
        // no need of explicitly saving Vehicle item entity - due to cascading

        return new ApplicationRes("Vehicle Deleted Successfully");

    }

    @Override
    public List<VehicleDto> getAllVehicle(Long userId) {
        userDao.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("No user with this id!!!"));

        return vehicleDao.findAll().stream()
        .map(v -> modelMapper.map(v, VehicleDto.class))
        .toList();
    }

    @Override
    public List<VehicleDto> getSoldVehiclesByDate(LocalDate date) {
        List<VehicleDto> res = vehicleDao.findAll()
                .stream()
                .filter(v -> v.getPurchaseDate().equals(date))
                .map(v -> {
                    VehicleDto vehicleDto = modelMapper.map(v, VehicleDto.class);
                    User user = v.getUser(); // Assuming Vehicle entity has a reference to User
                    if (user != null) {
                        vehicleDto.setUserName(user.getUname()); // Assuming VehicleDto has a userName field
                    }
                    return vehicleDto;
                })
                .toList();
        return res;
    }

}
