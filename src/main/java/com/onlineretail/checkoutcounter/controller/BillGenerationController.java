package com.onlineretail.checkoutcounter.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.onlineretail.checkoutcounter.service.BillGenerationService;

@RestController
public class BillGenerationController {

	@Autowired
	BillGenerationService billGenerationService;
	
	 @GetMapping("generate-bill1/counter/{counterId}")
	public String generateBill(@PathVariable int counterId) throws IOException {
		
		billGenerationService.generateBill(counterId);
		return "";
	}
	
}
