package com.cdac.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="food_items")
//lombok  annotations
@NoArgsConstructor
@Getter
@Setter
/*
 * ALWAYS exclude - association based properties from toString 
 * - especially in a bi dir asso (to avoid recursion - stack overflow!!!)
 */
@ToString(callSuper = true,exclude ="myRestaurant")
public class FoodItem extends BaseEntity {
	@Column(name="item_name",unique = true,length = 100)
	private String itemName;
	@Column(name="description")
	private String itemDescription;
	@Column(name="is_veg")
	private boolean isVeg;
	private int price;
	//FoodItem *---->1 Restaurant
	@ManyToOne
	@JoinColumn(name = "restaurant_id", nullable=false)	
	private Restaurant myRestaurant;
	public FoodItem(String itemName, String itemDescription, boolean isVeg, int price) {
		super();
		this.itemName = itemName;
		this.itemDescription = itemDescription;
		this.isVeg = isVeg;
		this.price = price;
	}
	
}
