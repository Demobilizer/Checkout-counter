package com.onlineretail.checkoutcounter.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlineretail.checkoutcounter.model.BillGeneration;

public interface BillGenerationRepository extends JpaRepository<BillGeneration, Integer> {

}
