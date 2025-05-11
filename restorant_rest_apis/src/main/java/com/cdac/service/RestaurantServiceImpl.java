package com.cdac.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cdac.custom_exceptions.ApiException;
import com.cdac.custom_exceptions.ResourceNotFoundException;
import com.cdac.dao.RestaurantDao;
import com.cdac.dto.RestaurantRespDto;
import com.cdac.entities.Restaurant;

@Service // => spring bean containing B.L
@Transactional // => auto tx management
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantDao restaurantDao;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<RestaurantRespDto> getAllRestaurants() {
		List<Restaurant> restaurantList = restaurantDao.findAll();
		return modelMapper.map(restaurantList, new TypeToken<List<RestaurantRespDto>>() {
		}.getType());
	}

	// => valid id , restaurant : persistent
	// simply access the size of the collection
	// restaurant.getFoodItems().size();//triggers another select query - food_items
	@Override
	public RestaurantRespDto getRestaurantDetails(Long restaurantId) {

		Restaurant restaurant = restaurantDao.findById(restaurantId)
				.orElseThrow(
						() -> new ResourceNotFoundException("Invalid Restaurant ID - not found !!!!!"));
		// Manually map nested food items if needed
		RestaurantRespDto dto = modelMapper.map(restaurant, RestaurantRespDto.class);
		return dto;
	}

	@Override
	public Restaurant addNewRestaurant(Restaurant transientEntity) {
		/*
		 * validate if the restaurant name already exists -yes - throw custom exception
		 * - name alrdy exists - no continue
		 */
		if (restaurantDao.findByName(
				transientEntity.getName()).isEmpty())
			return restaurantDao.save(transientEntity);
		throw new ApiException("Dup restaurant name !!!!!!");
	} // when transactional method rets - tx over - tx .commit
		// service layer rets DETACHED entity to the caller

	@Override
	public Restaurant updateRestaurant(Long rid, Restaurant newRes) {
		getRestaurantDetails(rid);
		if (restaurantDao.findByName(
				newRes.getName()).isEmpty()) {
			return restaurantDao.save(newRes);
		} else {
			throw new ApiException("Dup restaurant name !!!!!!");
		}
	}

	@Override
	public String deleteRestaurant(String name) {
		Restaurant rest = restaurantDao.findByName(name)
				.orElseThrow(() -> new ApiException("Dup restaurant name !!!!!!"));
		restaurantDao.delete(rest);
		return "Deleted Successfully";
	}

}
