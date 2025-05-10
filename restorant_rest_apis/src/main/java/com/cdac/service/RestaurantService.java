package com.cdac.service;

import java.util.List;

import com.cdac.entities.Restaurant;

public interface RestaurantService {
	// add a method to get all restaurants
	List<Restaurant> getAllRestaurants();

	// add a method to get specific restaurant details
	Restaurant getRestaurantDetails(Long restaurantId);

	// add a method to save new restaurant details
	Restaurant addNewRestaurant(Restaurant transientEntity);

	Restaurant updateRestaurant(Long rid, Restaurant newRes);

	String deleteRestaurant(String rname);
}
