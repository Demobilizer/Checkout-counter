package com.onlineretail.checkoutcounter.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.onlineretail.checkoutcounter.enums.BillGenerationStatus;
import com.onlineretail.checkoutcounter.model.OrderDetail;

public interface OrderRepository extends JpaRepository<OrderDetail, Integer> {

	//List<OrderDetail> findAllByCheckoutCounterCounterId(int counterId);

	List<OrderDetail> findAllByCheckoutCounterCounterIdAndBillGenerationStatus(int counterId, BillGenerationStatus billGenerationStatus);
		
}
