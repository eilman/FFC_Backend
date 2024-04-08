package com.ffc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ffc.entity.Restaurants;

public interface RestaurantRepository extends JpaRepository<Restaurants, Long> {

}
