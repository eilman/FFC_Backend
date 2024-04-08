package com.ffc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ffc.entity.Restaurants;
import com.ffc.repository.RestaurantRepository;
import com.ffc.service.RestaurantService;

@RestController
@RequestMapping("/ffc")
public class RestaurantController {
	
	private RestaurantService restaurantService;
	
	public RestaurantController(RestaurantService restaurantService) {
		super();
		this.restaurantService = restaurantService;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/restaurants")
	public List<Restaurants> getAllRestaurants(){
		return restaurantService.getAllRestaurants();
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/createRestaurant")
	public Restaurants createRestaurant(@RequestBody Restaurants savedRequest){
		return restaurantService.saveOneRestaurant(savedRequest);
		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/updateRestaurant/{restaurantId}")
	public Restaurants updateRestaurant(@PathVariable Long restaurantId, @RequestBody Restaurants savedRequest){
		return restaurantService.updateRestaurant(restaurantId, savedRequest);

	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/deleteRestaurant/{restaurantId}")
	public void deleteRestaurant(@PathVariable Long restaurantId){
		restaurantService.deleteOneRestaurant(restaurantId);

	}
	
}
