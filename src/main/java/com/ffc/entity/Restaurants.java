package com.ffc.entity;

import java.io.Serializable;

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
@Table(name="RESTAURANTS")
@Data
public class Restaurants {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RESTAURANT_ID")
	private Long restaurantId;
	@Column(name="RESTAURANT_NAME")
	private String restaurantName;
	@Column(name="RESTAURANT_ADDRESS")
	private String restaurantAddress;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="RESTAURANT_MANAGER_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	Users user;
	
	/*
	@Column(name="RESTAURANT_MANAGER_ID")
	private Long restaurantManagerId;
	*/
		
}
