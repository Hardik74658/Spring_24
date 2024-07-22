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
import com.services.FileUploadServices;

@Controller
public class EProductController {
	
	@Autowired
	EProductDao productDao;
	
	@Autowired
	FileUploadServices fileUpload;
	
	@GetMapping("deletebyname")
	public String deleteByName() {
		return "DeleteByName";
	}
	
	@GetMapping("/newproduct")
	public String newProduct() {
		return "NewProduct";
	}
	
	@PostMapping("/saveproduct")
	public String saveProduct(EProductBean productBean,@RequestParam("masterImage") MultipartFile masterImage) {
		
		System.out.println("master Image org Name : "+masterImage.getOriginalFilename());
		
		String path = "C:\\ROYAL\\SPRING\\STS\\Project1\\src\\main\\webapp\\images\\product";
		
		productBean.setProductImagePath("images\\product\\"+masterImage.getOriginalFilename());
		
		fileUpload.fileUpload(masterImage,path);
		
		productDao.addProduct(productBean);

		return "redirect:/products";
		
	}
	
	@GetMapping("/products")
	public String listProducts(Model model){
		
		
		List<EProductBean> list = productDao.getAllProducts();
		
		model.addAttribute("products",list);
		
		return "EcomListProducts";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productId") Integer productId) {
		
		productDao.deleteProduct(productId);
		
		return "redirect:/products";
	}
	
	
	@PostMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("productName") String productName,Model model) {
		
		Boolean productFound = false;
		
		List<EProductBean> list = productDao.getAllProducts();
		
		for (EProductBean product : list) {
			if(product.getProductName().equals(productName)) {
				productFound = true;
			}
		}
		
		if(productFound) {
			productDao.deleteProduct(productName);
			return "redirect:/products";
		}
		else {
			model.addAttribute("productNameError", "*Please Enter exact Name This Product Does Not Exist");
			return "DeleteByName";
		}
		
	}
	
	
	@GetMapping("/view")
	public String viewProduct(@RequestParam("productId") Integer productId,Model model) {
		
		EProductBean productBean = productDao.getProductById(productId);
		model.addAttribute("productBean",productBean);
		
		return "ViewProduct";
		
	}
	
	
}
