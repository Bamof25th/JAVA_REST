package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.custom_exceptions.ApiException;
import com.cdac.dto.FoodItemReqDto;
import com.cdac.service.FoodItemService;

@RestController
@RequestMapping("/foodItems")
public class FoodItemController {
    // 6. Solve- Add new Food item
    // * URL - http://host:port/food_items
    // * Method - POST
    // * payload - FoodItemcReqDTO (Restaurant Id food item details)
    // * Successful Resp - SC 201 + mesg (ApiResponse)
    // * Error resp - SC 400 , error mesg -wrapped in DTO(ApiResponse)
    @Autowired
    private FoodItemService foodItemsService;

    @GetMapping
    public ResponseEntity<?> getAllFoodItems() {

        try {
            return ResponseEntity.ok(foodItemsService.getAllFoodItems());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiException(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllFoodItemById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(foodItemsService.getFoodItemDetails(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiException(e.getMessage()));
        }
    }

    @GetMapping("/item")
    public ResponseEntity<?> getAllFoodItemByRId(@RequestParam Long rid) {
        try {
            return ResponseEntity.ok(foodItemsService.getFoodItemByRestaurantId(rid));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiException(e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<?> addFoodItem(@RequestBody FoodItemReqDto foodItem) {
        try {
            return ResponseEntity.ok(foodItemsService.createFoodItem(foodItem));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiException(e.getMessage()));

        }
    }
}
