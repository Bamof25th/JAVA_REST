package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ApplicationException;
import com.app.custom_exceptions.ResourcesNotFound;
import com.app.dao.CategoryDao;
import com.app.entites.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<Category> getAllCategories() {
		List<Category> list = categoryDao.findAll();
		if (!list.isEmpty()) {
			return list;
		} else {
			throw new ResourcesNotFound("Not available");
		}
	}

	@Override
	public String addCategory(Category newCategory) {
		
		try {
			if(categoryDao.getCategoryByName(newCategory.getName()).isEmpty()){
				categoryDao.save(newCategory);
			}
			return "Created The Category";
		} catch (RuntimeException e) {
			throw new ApplicationException("This Category is already available");
		}

	}

}