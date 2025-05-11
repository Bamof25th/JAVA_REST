package com.cdac.service;

import java.util.List;

import com.cdac.dto.FoodItemReqDto;
import com.cdac.dto.FoodItemRespDto;

public interface FoodItemService {

    List<FoodItemRespDto> getAllFoodItems();

    List<FoodItemRespDto> getFoodItemByRestaurantId(Long rid);

    FoodItemRespDto getFoodItemDetails(Long foodItemId);

    String updateFoodItemDetails(Long id, String desc, double price);

    FoodItemRespDto createFoodItem(FoodItemReqDto foodItem);
}
