package com.cdac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.custom_exceptions.ResourceNotFoundException;
import com.cdac.dao.FoodItemDao;
import com.cdac.entities.FoodItem;

@Service
@Transactional
public class FoodItemServiceImpl implements FoodItemService {
	//depcy 
	@Autowired
	private FoodItemDao foodItemDao;
	
	

	@Override
	public FoodItem getFoodItemDetails(Long foodItemId) {
		
		return foodItemDao.findById(foodItemId)
				.orElseThrow(() ->
				new ResourceNotFoundException("Invalid Food Item ID!!!!!"));
	}



	@Override
	public String updateFoodItemDetails(Long id, String desc, double price) {
		// Option 1 - findById n 2 setters (select , update)
		//OR - update jpql
		
		return "Updated "
		+foodItemDao.updateFoodItemDetails(price, desc, id)+" food item";
	}
	
	

}
