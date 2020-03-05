package com.onlineretail.checkoutcounter.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.onlineretail.checkoutcounter.dao.BillGenerationRepository;
import com.onlineretail.checkoutcounter.dao.CheckOutCounterRepository;
import com.onlineretail.checkoutcounter.dao.OrderRepository;
import com.onlineretail.checkoutcounter.enums.BillGenerationStatus;
import com.onlineretail.checkoutcounter.model.BillGeneration;
import com.onlineretail.checkoutcounter.model.CheckoutCounter;
import com.onlineretail.checkoutcounter.model.OrderDetail;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CheckOutCounterRepository checkOutCounterRepository;
	
	@Autowired
	BillGenerationRepository billGenerationRepository;

	public List<OrderDetail> getAllOrders() {
		
		return orderRepository.findAll();
	}

	public List<OrderDetail> getOrdersByCounterId(int counterId, BillGenerationStatus billGenerationStatus) {
		
		return orderRepository.findAllByCheckoutCounterCounterIdAndBillGenerationStatus(counterId, billGenerationStatus);
		
	}

	public void generateBill(List<OrderDetail> listOfOrderDetail, int counterId) {
		
		float totalAmount = 0;
		float totalTax = 0;
		float totalPayableAmount = 0;
		BillGeneration billGeneration = new BillGeneration();
		//OrderDetail orderDetail1 = new OrderDetail();

		for (OrderDetail orderDetail : listOfOrderDetail) {
	
				float price = orderDetail.getPrice();
				float quantity = orderDetail.getQuantity();
				float taxInPercentage = orderDetail.getTaxOnItem();
				System.out.println("product Name: "+orderDetail.getProductDetail().getProductName()+", price: "+price+", qty: "+quantity+", tax: "+taxInPercentage);
				float totalPrice = price*quantity;
				float taxInAmount = (totalPrice*taxInPercentage) / 100;
				float totalAmountOfItemAfterTaxAddition = totalPrice + taxInAmount;
				System.out.println("totalPrice: "+totalPrice+", taxInAmount: "+taxInAmount+", totalAmountOfItemAfterTaxAddition: "+totalAmountOfItemAfterTaxAddition);
				
				totalAmount = totalAmount + totalPrice;
				totalTax = totalTax + taxInAmount;
				totalPayableAmount = totalPayableAmount + totalAmountOfItemAfterTaxAddition;
				
				orderDetail.setBillGenerationStatus(BillGenerationStatus.COMPLETED);
			}
		
			System.out.println("totalAmount: "+totalAmount);
			System.out.println("totalTax: "+totalTax);
			System.out.println("totalPaybleAmount: "+totalPayableAmount);
			
			if(totalAmount != 0 && totalPayableAmount != 0 && totalTax != 0)
			{
				billGeneration.setTotalAmount(totalAmount);
				billGeneration.setTotalTax(totalTax);
				billGeneration.setTotalPayableAmount(totalPayableAmount);
				
				billGeneration.setCheckoutCounter(checkOutCounterRepository.findById(counterId).orElse(null));
				
				Date dateAndTimeNow = new Date();
				billGeneration.setDateAndTime(dateAndTimeNow);
				
				BillGeneration billGeneration2 = billGenerationRepository.save(billGeneration);
				orderRepository.saveAll(listOfOrderDetail);
				for (OrderDetail orderDetail : listOfOrderDetail) {
					orderDetail.setBillGeneration(billGeneration2);
					orderRepository.save(orderDetail);
				}
				
			}
			
	}
	
}
