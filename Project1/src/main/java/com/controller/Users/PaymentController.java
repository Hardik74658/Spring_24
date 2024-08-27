package com.controller.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.services.EmailService;

@Controller
public class PaymentController {

	@Autowired
	EmailService emailService;
	
	@GetMapping("/checkout")
	public String checkout() {
		return "Checkout";
	}
	
	
	@GetMapping("/inputemail")
	public String inputEmail() {

		return "InputEmail";
	}

	
	@PostMapping("/sendmail")
	public String sendMail(@RequestParam("email") String email) {
		System.out.println(email);
		emailService.sendDemoMail(email, "Hey Welcome to Royal");
		
		return "Success";
	}
	
}
