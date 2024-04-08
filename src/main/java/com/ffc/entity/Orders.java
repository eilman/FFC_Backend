package com.ffc.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
*/
@Entity
@Table(name="ORDERS")
@Data
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ORDER_ID")
	private Long orderId;
	@Column(name="PRODUCT_NAME")
	private String productName;
	@Column(name="DELIVERY_ADDRESS")
	private String deliveryAddress;
	@Column(name="PHONE")
	private String phone;
	@Column(name="STATUS")
	private String status;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "RESTAURANT_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	Restaurants restaurant;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="USER_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	Users user;
	

}
