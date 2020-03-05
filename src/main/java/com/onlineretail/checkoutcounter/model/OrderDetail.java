package com.onlineretail.checkoutcounter.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

import com.onlineretail.checkoutcounter.enums.BillGenerationStatus;

@Component
@Entity
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int orderedItemId;
	
	@JoinColumn(name = "productId")
	@OneToOne(cascade = CascadeType.ALL)
	private ProductDetail productDetail;
	
	@ManyToOne(targetEntity = CheckoutCounter.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "counterId")
	private CheckoutCounter checkoutCounter;
	
	@ManyToOne(targetEntity = BillGeneration.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "billId")
	private BillGeneration billGeneration;
	
	private int quantity;
	private float taxOnItem;
	private float price;
	
	@Enumerated(EnumType.STRING)
	private BillGenerationStatus billGenerationStatus;
	
	public BillGeneration getBillGeneration() {
		return billGeneration;
	}
	public void setBillGeneration(BillGeneration billGeneration) {
		this.billGeneration = billGeneration;
	}
	public BillGenerationStatus getBillGenerationStatus() {
		return billGenerationStatus;
	}
	public void setBillGenerationStatus(BillGenerationStatus billGenerationStatus) {
		this.billGenerationStatus = billGenerationStatus;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setProductDetail(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}
	public int getOrderedItemId() {
		return orderedItemId;
	}
	public void setOrderedItemId(int orderedItemId) {
		this.orderedItemId = orderedItemId;
	}

	public ProductDetail getProductDetail() {
		return productDetail;
	}
	public void setProductSet(ProductDetail productDetail) {
		this.productDetail = productDetail;
	}
	
	public CheckoutCounter getCheckoutCounter() {
		return checkoutCounter;
	}
	public void setCheckoutCounter(CheckoutCounter checkoutCounter) {
		this.checkoutCounter = checkoutCounter;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTaxOnItem() {
		return taxOnItem;
	}
	public void setTaxOnItem(float taxOnItem) {
		this.taxOnItem = taxOnItem;
	}
	@Override
	public String toString() {
		return "OrderDetail [orderedItemId=" + orderedItemId + ", productDetail=" + productDetail + ", checkoutCounter="
				+ checkoutCounter + ", billGeneration=" + billGeneration + ", quantity=" + quantity + ", taxOnItem="
				+ taxOnItem + ", price=" + price + ", billGenerationStatus=" + billGenerationStatus + "]";
	}
	
}
