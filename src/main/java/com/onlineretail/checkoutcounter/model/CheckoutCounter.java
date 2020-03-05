package com.onlineretail.checkoutcounter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class CheckoutCounter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int counterId;

	public int getCounterId() {
		return counterId;
	}

	public void setCounterId(int counterId) {
		this.counterId = counterId;
	}

	@Override
	public String toString() {
		return "CheckoutCounter [counterId=" + counterId + "]";
	}
	
}
