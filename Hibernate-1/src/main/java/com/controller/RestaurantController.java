package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.RestaurantEntity;
import com.repository.RestaurantRepository;

import jakarta.validation.Valid;

@Controller
public class RestaurantController {

	@Autowired
	RestaurantRepository restaurantRepository;

	@GetMapping("newrestaurant")
	public String newRestaurant() {

		return "NewRestaurant";
	}

	@PostMapping("saverestaurant")
	public String saveRestaurant(@Validated  RestaurantEntity restaurantEntity,BindingResult result,Model model) {
		
		
		if(result.hasErrors()) {
			model.addAttribute("result", result);
			return "NewRestaurant";
		}
		else {
			restaurantRepository.save(restaurantEntity);// insert
		}
	
		
		return "Success";
	}
	
	@GetMapping("listrestaurants")
	public String listRestaurants(Model model) {
		
		List<RestaurantEntity> restaurants = (List<RestaurantEntity>)restaurantRepository.findAll();
		model.addAttribute("restaurants", restaurants);
		
		return "ListRestaurant";
	}
}