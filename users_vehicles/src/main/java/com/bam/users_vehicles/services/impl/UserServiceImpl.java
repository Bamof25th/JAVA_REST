package com.bam.users_vehicles.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bam.users_vehicles.dao.UserDao;
import com.bam.users_vehicles.dto.UserDto;
import com.bam.users_vehicles.entites.User;
import com.bam.users_vehicles.services.UserService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final ModelMapper modelMapper;

    @Override
    public UserDto SignUp(UserDto userDto) {
        User user = userDao.save(modelMapper.map(userDto, User.class));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto signIn(String email, String password) {
        User user = userDao.findByEmailAndPassword(email, password).orElseThrow(
                () -> new IllegalStateException("Please Check User Id And Password"));
        return modelMapper.map(user, UserDto.class);
    }

}
