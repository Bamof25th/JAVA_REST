package com.cdac.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.custom_exceptions.ApiException;
import com.cdac.custom_exceptions.ResourceNotFoundException;
import com.cdac.dao.FoodItemDao;
import com.cdac.dao.RestaurantDao;
import com.cdac.dto.FoodItemReqDto;
import com.cdac.dto.FoodItemRespDto;
import com.cdac.entities.FoodItem;
import com.cdac.entities.Restaurant;

@Service
@Transactional
public class FoodItemServiceImpl implements FoodItemService {

	@Autowired
	private FoodItemDao foodItemDao;
	@Autowired
	private RestaurantDao restaurantDao;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<FoodItemRespDto> getAllFoodItems() {
		return foodItemDao.findAll().stream().map((f) -> modelMapper.map(f, FoodItemRespDto.class)).toList();
		// throw new ApiException("Unimplemented method 'getAllFoodItems'");
	}

	@Override
	public FoodItemRespDto getFoodItemDetails(Long foodItemId) {

		FoodItem fi = foodItemDao.findById(foodItemId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Food Item ID!!!!!"));
		return modelMapper.map(fi, FoodItemRespDto.class);
	}

	@Override
	public String updateFoodItemDetails(Long id, String desc, double price) {
		// Option 1 - findById n 2 setters (select , update)
		// OR - update jpql

		return "Updated "
				+ foodItemDao.updateFoodItemDetails(price, desc, id) + " food item";
	}

	@Override
	public List<FoodItemRespDto> getFoodItemByRestaurantId(Long rid) {
		List<FoodItem> list = foodItemDao.findByRestaurantId(rid);
		return list.stream().map((f) -> modelMapper.map(f, FoodItemRespDto.class)).toList();
	}

	@Override
	public FoodItemRespDto createFoodItem(FoodItemReqDto foodItemDto) {
		if (foodItemDao.findByFoodName(foodItemDto.getItemName()).isEmpty()) {
			// Convert DTO to entity
			FoodItem foodItem = new FoodItem(
					foodItemDto.getItemName(),
					foodItemDto.getItemDescription(),
					foodItemDto.isVeg(),
					foodItemDto.getPrice());

			Restaurant restaurant = restaurantDao.findById(foodItemDto.getRestaurantId())
					.orElseThrow(() -> new ResourceNotFoundException("Invalid restaurant Item ID!!!!!"));
					
			foodItem.setMyRestaurant(restaurant);

			// Save and return mapped response
			return modelMapper.map(foodItemDao.save(foodItem), FoodItemRespDto.class);
		}
		throw new ApiException("Dupe food item name!!");
	}

}
