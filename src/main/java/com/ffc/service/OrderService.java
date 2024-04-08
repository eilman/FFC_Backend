package com.ffc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ffc.entity.Orders;
import com.ffc.entity.Restaurants;
import com.ffc.repository.OrdersRepository;
import com.ffc.repository.RestaurantRepository;
import com.ffc.repository.UserRepository;

@Service
public class OrderService {

	OrdersRepository orderRepository;
	UserRepository userRepository;
	@Autowired
	RestaurantRepository restaurantRepository;

	public OrderService(OrdersRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public List<Orders> getAllOrders() {
		return orderRepository.findAll();
	}

	public Orders saveOneOrder(Long userId, Orders savedRequest) {
		Long restaurantIdForOrder = (long) 0;
		savedRequest.getUser().setUserId(userId);
		List<Restaurants> allRestaurants = restaurantRepository.findAll();
		for(Restaurants rest: allRestaurants) {
			if(rest.getRestaurantName().equals(savedRequest.getRestaurant().getRestaurantName()) ) {
				restaurantIdForOrder = rest.getRestaurantId();
			}
		}
		savedRequest.getRestaurant().setRestaurantId(restaurantIdForOrder);
		return orderRepository.save(savedRequest);
	}

	public Orders updateOrder(Long orderId, Orders savedRequest) {
		Optional<Orders> order = orderRepository.findById(orderId);
		if(order.isPresent()) {
			Orders foundOrder = order.get();
			foundOrder.setDeliveryAddress(savedRequest.getDeliveryAddress());
			foundOrder.setPhone(savedRequest.getPhone());
			foundOrder.setProductName(savedRequest.getProductName());
			foundOrder.getRestaurant().setRestaurantId(savedRequest.getRestaurant().getRestaurantId());
			foundOrder.setStatus(savedRequest.getStatus());
			foundOrder.getUser().setUserId(savedRequest.getUser().getUserId());
			orderRepository.save(foundOrder);
			return foundOrder;
		}else {
			//Custom exception should be added.
			return null;
		}
	}

	public void deleteOneOrder(Long orderId) {
		orderRepository.deleteById(orderId);
	}
	
	
}
