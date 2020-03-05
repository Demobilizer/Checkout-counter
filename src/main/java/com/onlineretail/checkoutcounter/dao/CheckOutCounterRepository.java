package com.onlineretail.checkoutcounter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineretail.checkoutcounter.model.CheckoutCounter;

public interface CheckOutCounterRepository extends JpaRepository<CheckoutCounter, Integer>{

}
