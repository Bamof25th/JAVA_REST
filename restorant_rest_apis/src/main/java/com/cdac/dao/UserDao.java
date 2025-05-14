package com.cdac.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

    Optional<User> findByFirstName(String firstName);

}
