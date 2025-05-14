package com.cdac.service;

import org.springframework.stereotype.Service;

import com.cdac.dao.UserDao;
import com.cdac.entities.User;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceInf implements UserService {

    private final UserDao userDao;

    @Override
    @Transactional
    public User createUser(User user) {
        // userDao.findByFirstName(user.getFirstName())
        //         .orElseThrow(() -> new IllegalArgumentException("Name is jkjklkjk"));
        return userDao.save(user);
    }

}
