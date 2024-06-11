package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.CalcBean;

@Controller
public class CalcController {
	
	@GetMapping("/calc")
	public String Calc() {
		return "Calc";
	}
	
	@PostMapping("/add")
	public String addNums(CalcBean cb,Model model) {
		
		int sum = cb.getNum1()+cb.getNum2();
		model.addAttribute("num1", cb.getNum1());
		model.addAttribute("num2", cb.getNum2());
		model.addAttribute("sum", sum);
		return "CalcRes";
	}
	
}
