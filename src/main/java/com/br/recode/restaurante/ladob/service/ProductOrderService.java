package com.br.recode.restaurante.ladob.service;

import org.springframework.stereotype.Service;

import com.br.recode.restaurante.ladob.repository.ProductOrderRepository;

@Service
public class ProductOrderService {

	private ProductOrderRepository productOrderRepository;

	public ProductOrderService(ProductOrderRepository productOrderRepository) {
		super();
		this.productOrderRepository = productOrderRepository;
	}
	
	
}
