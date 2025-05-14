package com.bam.users_vehicles.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bam.users_vehicles.entites.User;

public interface UserDao extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    // sign in
    Optional<User> findByEmailAndPassword(String em, String pass);
}
