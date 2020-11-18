package com.br.recode.restaurante.ladob.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.recode.restaurante.ladob.model.Orders;
import com.br.recode.restaurante.ladob.model.Products;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

	List<Products> findByIdEquals(Long id);
	
	List<Products> findByOrderDateEquals(Date orderDate);
		
	
}
