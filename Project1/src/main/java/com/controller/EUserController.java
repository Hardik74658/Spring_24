package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.EUserBean;
import com.dao.EUserDao;
import com.services.FileUploadServices;

import jakarta.servlet.http.HttpSession;


@Controller
public class EUserController {

	@Autowired
	EUserDao userDao;
	
	@Autowired
	FileUploadServices fileServices;
	
	@GetMapping("/signup")
	public String signup() {
		return "EUserSignup";
	}
	
	@GetMapping("/home")
	public String home() {
		return "EComHome";
	}
	
	@GetMapping("/elogin")
	public String login() {
		return "EComLogin";
	}
	
	@PostMapping("/elogin")
	public String EComLogin(EUserBean userBean,Model model,HttpSession session) {
		
		EUserBean loggedUser = userDao.authenticate(userBean.getEmail() , userBean.getPassword()); 
		
		if(loggedUser == null) {
			
			model.addAttribute("error","Invalid Credentials");
			
			return "EComLogin";
		}
		
		session.setAttribute("user",loggedUser);
		
		return "EComHome";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/elogin";
	}
	
	
	@PostMapping("/signup")
	public String eUserSignup(EUserBean userBean) {
		
		String path= "C:\\ROYAL\\SPRING\\STS\\Project1\\src\\main\\webapp\\images\\users\\"+userBean.getEmail()+"\\";
		String dbPath= "images\\users\\"+userBean.getEmail()+"\\";
		userBean.setProfilePicPath(dbPath+userBean.getProfilePic().getOriginalFilename());
		
		fileServices.fileUpload(userBean.getProfilePic(),path);
		
		userDao.insertUser(userBean);
		
		return "redirect:/listusers";
	}
	
	@GetMapping("/listusers")
	public String listUsers(Model model) {
			
		
		List<EUserBean> list = userDao.getAllUsers();
		model.addAttribute("users",list);
		
		return "ListUsers";
		
	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("id") Integer id) {
		
		userDao.deleteUser(id);
		
		return "redirect:/listusers";
	}
	
	
}
