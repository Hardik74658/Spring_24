package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bean.StudentBoxCricketRegBean;
import com.util.validators;

@Controller
public class StudentBoxCricketRegController {

	
	@GetMapping("/registerationBoxCricket")
	public String registerBoxCricket() {
		return "StudentBoxCricketReg";
	}
	
	@PostMapping("/registerStudentBoxCricket")
	public String registration(StudentBoxCricketRegBean sbean,Model model){
		
		System.out.println("Student Name : "+sbean.getStudentName());
		System.out.println("Player Type : "+sbean.getPlayerType());
		System.out.println("Food Preference : "+sbean.getFoodPrefernce());
		System.out.println("Drink : "+sbean.getDrink());
		
		boolean isError  = false;
		
		if(validators.isBlank(sbean.getStudentName())) {
			isError=true;
			model.addAttribute("studentNameError", "*Please Enter Name");
			
		}
		else if(!validators.isAlpha(sbean.getStudentName())) {
			isError=true;
			model.addAttribute("studentNameError", "*Please Enter Valid Name");	
		}
		else {
			model.addAttribute("studentName", sbean.getStudentName());
		}
		
		if(validators.isBlank(sbean.getPlayerType())) {
			isError=true;
			model.addAttribute("playerTypeError", "*Please Select Playing Type");
		}
		else {
			model.addAttribute(sbean.getPlayerType()+"Checked", "checked");
			model.addAttribute("playerType", sbean.getPlayerType());
		}
		
		if(sbean.getFoodPrefernce().equals("-1")) {
			isError=true;
			model.addAttribute("foodPreferenceError", "*Please Select Food Preference");
		}else {
			model.addAttribute(sbean.getFoodPrefernce()+"Selected", "selected");
			model.addAttribute("foodPreference", sbean.getFoodPrefernce());
		}
		if(validators.isBlank(sbean.getDrink())) {
			isError=true;
			model.addAttribute("drinkError", "*Please Select Drink");
		}else {
			String drinksArr[] = sbean.getDrink().split(",");
			for (String string : drinksArr) {
				model.addAttribute(string+"Checked","checked"); 
			}
		}
		
		
		model.addAttribute("drink", sbean.getDrink());
		
		if(isError) {
			return "StudentBoxCricketReg";
		}
		else {
			return "BoxCricket";
		}
	}
	
}
