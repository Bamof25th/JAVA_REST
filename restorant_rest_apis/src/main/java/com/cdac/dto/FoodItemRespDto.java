package com.cdac.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodItemRespDto extends BaseEntityDto {
    // private Long id;
    private String itemName;
    private String itemDescription;
    private boolean isVeg;
    private int price;
    // private Restaurant myRestaurant;
    private Long restaurantId; // Just the ID
}
