package com.cdac.service;

import java.util.List;

import com.cdac.dto.RestaurantRespDto;
import com.cdac.entities.Restaurant;

public interface RestaurantService {
	// add a method to get all restaurants
	List<RestaurantRespDto> getAllRestaurants();

	// add a method to get specific restaurant details
	RestaurantRespDto getRestaurantDetails(Long restaurantId);

	// add a method to save new restaurant details
	Restaurant addNewRestaurant(Restaurant transientEntity);

	Restaurant updateRestaurant(Long rid, Restaurant newRes);

	String deleteRestaurant(String rname);
}
