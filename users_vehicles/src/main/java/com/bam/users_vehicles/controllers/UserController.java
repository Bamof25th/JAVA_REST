package com.bam.users_vehicles.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bam.users_vehicles.dto.UserDto;
import com.bam.users_vehicles.dto.UserLoginDto;
import com.bam.users_vehicles.services.UserService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<?> SignUp(@RequestBody UserDto userDto) {
        UserDto resUser = userService.SignUp(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> SignIn(@RequestBody UserLoginDto userDto) {
        UserDto userData = userService.signIn(userDto.getEmail(), userDto.getPassword());
        return ResponseEntity.ok(userData);
    }

}
