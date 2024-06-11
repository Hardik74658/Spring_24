package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.UserBean;


@Controller
public class SessionController {

	@GetMapping("/signup")
	public String signup() {	
		return "Signup";
	}
	@GetMapping("/login")
	public String login() {	
		return "Login";
	}
	@GetMapping("/fp")
	public String forgetPassword() {	
		return "ForgetPassword";
	}
	
	
	@PostMapping("/saveuser")
	public String saveuser(UserBean userBean,Model model) {
		
		System.out.println("firstName => "+userBean.getFirstName());
		System.out.println("email => "+userBean.getEmail());
		System.out.println("password => "+userBean.getPassword());
		
		model.addAttribute("user", userBean);
		
		return "Home";
		
	}
	
	
	
}
