package com.cdac.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodItemReqDto {
    private String itemName;
    private String itemDescription;
    private boolean isVeg;
    private int price;
    private Long restaurantId; // Just the ID
}
