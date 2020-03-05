package com.onlineretail.checkoutcounter.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.onlineretail.checkoutcounter.enums.BillGenerationStatus;
import com.onlineretail.checkoutcounter.model.OrderDetail;
import com.onlineretail.checkoutcounter.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@GetMapping("/get-all-orders")
	public List<OrderDetail> getAllOrders()
	{
		List<OrderDetail> orderDetailList = orderService.getAllOrders();
		return orderDetailList;
	}
	
	@GetMapping("/get-orders-by-id/counter/{counterId}")
	public List<OrderDetail> getOrdersByBillId(@PathVariable int counterId)
	{
		BillGenerationStatus status = BillGenerationStatus.PENDING;
		return orderService.getOrdersByCounterId(counterId, status);
	}
	
	 @GetMapping("generate-bill/counter/{counterId}") 
	public String generateBill(@PathVariable int counterId)
	{
		 
		BillGenerationStatus status = BillGenerationStatus.PENDING;
		List<OrderDetail> listOfOrderDetail = orderService.getOrdersByCounterId(counterId, status);
		
		orderService.generateBill(listOfOrderDetail, counterId);
		
		return "";
	}
	
}
