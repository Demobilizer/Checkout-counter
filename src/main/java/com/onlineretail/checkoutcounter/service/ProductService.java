package com.onlineretail.checkoutcounter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineretail.checkoutcounter.dao.ProductRepository;
import com.onlineretail.checkoutcounter.model.ProductDetail;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public void makeOrder(ProductDetail productDetail) {

		productRepository.save(productDetail);
	}
	
}
