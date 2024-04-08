package com.ffc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ffc.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
