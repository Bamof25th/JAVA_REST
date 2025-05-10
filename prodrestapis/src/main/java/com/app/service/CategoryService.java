package com.app.service;

import java.util.List;

import com.app.entites.Category;

public interface CategoryService {
	List<Category> getAllCategories();

	String addCategory(Category newCategory);
}
