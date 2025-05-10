package com.cdac.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="restaurants")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true/* ,exclude = "foodItems" */)
@EqualsAndHashCode(of = "name",callSuper = false)
public class Restaurant extends BaseEntity{
	@Column(length = 50,unique = true)
	private String name;
	private String address;
	@Column(length = 30)
	private String city;
	private String description;
	//always init the collection - to avoid NullPointerException
	//Restaurant 1---->* FoodItem
	//Restaurant - one , parent table , inverse side
//	@OneToMany(mappedBy = "myRestaurant",orphanRemoval = true,
//			cascade = CascadeType.ALL/* ,fetch = FetchType.EAGER */)
//	private List<FoodItem>foodItems=new ArrayList<>();
	public Restaurant(String name, String address, String city, String description) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.description = description;
	}
	//Helper method to establish a bi dir asso between Restaurant 1----* FoodItem
//	public void addFoodItem(FoodItem foodItem) {
//		this.foodItems.add(foodItem);//parent -> child
//		foodItem.setMyRestaurant(this);//child -> parent		
//	}
//	//Helper method to de link a bi dir asso between Restaurant 1----* FoodItem
//	public void removeFoodItem(FoodItem foodItem) {
//		this.foodItems.remove(foodItem);
//		foodItem.setMyRestaurant(null);
//		
//	}
}
