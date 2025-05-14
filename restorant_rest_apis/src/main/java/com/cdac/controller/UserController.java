package com.cdac.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.UserDto;
import com.cdac.entities.User;
import com.cdac.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;

    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {

        User user = userService.createUser(modelMapper.map(userDto, User.class));

        return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(user, UserDto.class));
    }

}
