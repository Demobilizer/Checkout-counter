package com.onlineretail.checkoutcounter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlineretail.checkoutcounter.model.ProductDetail;
import com.onlineretail.checkoutcounter.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	
	  @PostMapping("/addProductToCart") public String makeOrder(@RequestBody ProductDetail productDetail) { 
		  productService.makeOrder(productDetail); 
		  return "product successfully added to cart!"; 
	  }
	 
	
}
