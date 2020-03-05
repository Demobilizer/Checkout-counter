package com.onlineretail.checkoutcounter.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class BillGeneration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int billId;
	private Date dateAndTime;
	private float totalAmount;
	private float totalTax;
	private float totalPayableAmount;
	
	@OneToOne(targetEntity = CheckoutCounter.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "counterId")
	private CheckoutCounter checkoutCounter;
	
	public CheckoutCounter getCheckoutCounter() {
		return checkoutCounter;
	}

	public void setCheckoutCounter(CheckoutCounter checkoutCounter) {
		this.checkoutCounter = checkoutCounter;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public float getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(float totalTax) {
		this.totalTax = totalTax;
	}

	public float getTotalPayableAmount() {
		return totalPayableAmount;
	}

	public void setTotalPayableAmount(float totalPayableAmount) {
		this.totalPayableAmount = totalPayableAmount;
	}

	@Override
	public String toString() {
		return "BillGeneration [billId=" + billId + ", dateAndTime=" + dateAndTime + ", totalAmount=" + totalAmount
				+ ", totalTax=" + totalTax + ", totalPayableAmount=" + totalPayableAmount + ",  checkoutCounter=" + checkoutCounter + "]";
	}

	
}
