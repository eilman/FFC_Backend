package com.ffc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffc.entity.Restaurants;
import com.ffc.entity.Users;
import com.ffc.repository.RestaurantRepository;
import com.ffc.repository.UserRepository;

@Service
public class RestaurantService {
	
	RestaurantRepository restaurantRepository;
	@Autowired
	UserRepository userRepository;

	public RestaurantService(RestaurantRepository restaurantRepository) {
		this.restaurantRepository = restaurantRepository;
	}

	public List<Restaurants> getAllRestaurants() {
		return restaurantRepository.findAll();
	}

	public Restaurants saveOneRestaurant(Restaurants savedRequest) {
		Long restManagerId = (long) 0;
		List<Users> allUsers = userRepository.findAll();
		for(Users user: allUsers) {
			if(user.getUsername().equals(savedRequest.getUser().getUsername()) ) {
				restManagerId = user.getUserId();
			}
		}
		savedRequest.getUser().setUserId(restManagerId);
		return restaurantRepository.save(savedRequest);
	}

	public void deleteOneRestaurant(Long restaurantId) {
		restaurantRepository.deleteById(restaurantId);
	}

	public Restaurants updateRestaurant(Long restaurantId, Restaurants savedRequest) {
		Optional<Restaurants> restaurant = restaurantRepository.findById(restaurantId);
		if(restaurant.isPresent()) {
			Restaurants foundRest = restaurant.get();
			foundRest.setRestaurantAddress(savedRequest.getRestaurantAddress());
			//??
			foundRest.getUser().setUserId(savedRequest.getUser().getUserId());
			foundRest.setRestaurantName(savedRequest.getRestaurantName());
			restaurantRepository.save(foundRest);
			return foundRest;
		}else {
			//Custom exception should be added.
			return null;
		}
	}
	
	

}
