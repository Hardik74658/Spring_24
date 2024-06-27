package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.EProductBean;
import com.dao.EProductDao;

@Controller
public class EProductController {
	
	@Autowired
	EProductDao productDao;
	
	@GetMapping("/newproduct")
	public String newProduct() {
		return "NewProduct";
	}
	
	@PostMapping("/saveproduct")
	public String saveProduct(EProductBean productBean,@RequestParam("masterImage") MultipartFile masterImage) {
		
		System.out.println("master Image org Name : "+masterImage.getOriginalFilename());
		
		productDao.addProduct(productBean);
		return "redirect:/products";
		
	}
	
	@GetMapping("/products")
	public String listProducts(Model model){
		
		
		List<EProductBean> list = productDao.getAllProducts();
		
		model.addAttribute("products",list);
		
		return "EcomListProducts";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("productId") Integer productId) {
		
		System.out.println("/delete?productId="+productId);
		productDao.deleteProduct(productId);
		
		return "redirect:/products";
	}
	
	
	@GetMapping("/view")
	public String viewProduct(@RequestParam("productId") Integer productId,Model model) {
		
		EProductBean productBean = productDao.getProductById(productId);
		model.addAttribute("productBean",productBean);
		
		return "ViewProduct";
		
	}
}
