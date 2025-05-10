package com.cdac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cdac.entities.FoodItem;

public interface FoodItemDao extends JpaRepository<FoodItem,Long> {
//add update JPQL
	@Query("update FoodItem f set f.price=:price ,"
			+ "f.itemDescription=:desc where f.id=:id")
	@Modifying
	int updateFoodItemDetails(double price,String desc,Long id);
}
