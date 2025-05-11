package com.cdac.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cdac.entities.FoodItem;

public interface FoodItemDao extends JpaRepository<FoodItem, Long> {
	// add update JPQL
	@Query("update FoodItem f set f.price=:price ,"
			+ "f.itemDescription=:desc where f.id=:id")
	@Modifying
	int updateFoodItemDetails(double price, String desc, Long id);

	@Query("SELECT f FROM FoodItem f WHERE f.myRestaurant.id = :id")
	List<FoodItem> findByRestaurantId(Long id);

	@Query("SELECT f FROM FoodItem f WHERE f.itemName = :name")
	Optional<FoodItem> findByFoodName(String name);

}
