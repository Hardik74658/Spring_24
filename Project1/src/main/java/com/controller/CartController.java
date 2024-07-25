package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.ECartBean;
import com.bean.EProductBean;
import com.bean.EUserBean;
import com.dao.ECartDao;

import jakarta.servlet.http.HttpSession;



@Controller
public class CartController {

	@Autowired
	ECartDao cartDao;

	
	
	@GetMapping("/addtocart")
	public String addToCart(@RequestParam("productId") Integer productId,HttpSession session) {
		
		EUserBean userBean = (EUserBean)session.getAttribute("user");
		
		Integer userId = userBean.getId();
		
		ECartBean cartBean =	new ECartBean();
		
		cartBean.setUserId(userId);
		cartBean.setProductId(productId);
		
		cartDao.addTocart(cartBean);
		
		return "redirect:/userproducts";
	}
	
	@GetMapping("/mycart")
	public String myCart(Model model,HttpSession session) {
		
		EUserBean user = (EUserBean)session.getAttribute("user");
			
		Integer userId = user.getId();
		
		List<EProductBean> products = cartDao.myCart(userId);
		
		model.addAttribute("products", products);
						
		return "MyCart";
	}
	
	
	@GetMapping("/removecartitem")
	public String removeFromCart(@RequestParam("productId") Integer productId) {
			
		cartDao.removeProductFromCart(productId);
		
		return "redirect:/mycart";
	}
	
}
