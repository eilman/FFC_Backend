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

import com.ffc.entity.Orders;
import com.ffc.repository.OrdersRepository;
import com.ffc.service.OrderService;


@RestController
@RequestMapping("/ffc")
public class OrderController {
	
	private OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/orders")
	public List<Orders> getAllOrders(){
		return orderService.getAllOrders();
		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/createOrder/{userId}")
	public Orders createOrder(@PathVariable Long userId, @RequestBody Orders savedRequest){
		return orderService.saveOneOrder(userId, savedRequest);
		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PutMapping("/updateOrder/{orderId}")
	public Orders updateOrder(@PathVariable Long orderId, @RequestBody Orders savedRequest){
		return orderService.updateOrder(orderId, savedRequest);
		
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/deleteOrder/{orderId}")
	public void deleteOrder(@PathVariable Long orderId){
		orderService.deleteOneOrder(orderId);
		
	}
	
}
