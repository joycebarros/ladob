package com.br.recode.restaurante.ladob.service;

import org.springframework.stereotype.Service;

import com.br.recode.restaurante.ladob.repository.OrdersRepository;

@Service
public class OrdersService {
	
	private OrdersRepository ordersRepository;

	public OrdersService(OrdersRepository ordersRepository) {
		super();
		this.ordersRepository = ordersRepository;
	}

}
