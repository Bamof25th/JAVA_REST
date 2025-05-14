package com.bam.users_vehicles.services;

import com.bam.users_vehicles.dto.UserDto;

public interface UserService {

    UserDto SignUp(UserDto userDto);

    UserDto signIn(String email, String password);

}
