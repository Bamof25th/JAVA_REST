package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entites.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {
     Optional<Category> getCategoryByName(String name);
}
