package com.cdac.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantRespDto extends BaseEntityDto {
	private String name;
	private String address;
	private String city;
	private String description;
	private List<FoodItemRespDto> foodItems;
}
