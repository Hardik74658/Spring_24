package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.entity.UserEntity;

@Controller
public class UserController {

	@GetMapping("/newuser")
	public String newUser() {
		return "NewUser";
	}
	
	@PostMapping("saveUser")
	public String saveUser(UserEntity user) {
		System.out.println("User Email : "+user.getEmail());
		
		return "NewUser";
	}
	
}
