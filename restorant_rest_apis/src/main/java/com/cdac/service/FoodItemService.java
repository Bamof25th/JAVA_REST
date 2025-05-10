package com.cdac.service;

import com.cdac.entities.FoodItem;

public interface FoodItemService {
 FoodItem getFoodItemDetails(Long foodItemId);
String updateFoodItemDetails(Long id, String desc, double price);
}
