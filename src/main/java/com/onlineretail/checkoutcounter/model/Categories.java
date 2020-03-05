package com.onlineretail.checkoutcounter.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int catId;
	private String catType;
	private float taxAssociated;
	
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatType() {
		return catType;
	}
	public void setCatType(String catType) {
		this.catType = catType;
	}
	
	public float getTaxAssociated() {
		return taxAssociated;
	}
	public void setTaxAssociated(float taxAssociated) {
		this.taxAssociated = taxAssociated;
	}
	@Override
	public String toString() {
		return "Categories [catId=" + catId + ", catType=" + catType + ", taxAssociated=" + taxAssociated + "]";
	}
	
}
