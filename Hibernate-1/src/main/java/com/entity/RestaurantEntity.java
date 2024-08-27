package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "restaurants")
@FieldDefaults(level=AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
public class RestaurantEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	Integer restaurantId;
	@NotBlank(message = "*Please Enter Restaurant Name")
	String name;
	@NotBlank(message = "*Please Enter Restaurant Address")
	String address;
	@NotBlank(message = "*Please Enter Restaurant Category")
	String category;

}