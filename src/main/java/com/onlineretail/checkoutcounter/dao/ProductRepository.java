package com.onlineretail.checkoutcounter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineretail.checkoutcounter.model.ProductDetail;

public interface ProductRepository extends JpaRepository<ProductDetail, Integer> {

}
