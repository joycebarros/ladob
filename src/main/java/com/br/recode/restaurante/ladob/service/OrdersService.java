package com.br.recode.restaurante.ladob.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.recode.restaurante.ladob.model.Orders;
import com.br.recode.restaurante.ladob.repository.OrdersRepository;

@Service
public class OrdersService {
	
	private OrdersRepository ordersRepository;

	public OrdersService(OrdersRepository ordersRepository) {
		super();
		this.ordersRepository = ordersRepository;
	}

	public List<Orders> findAll() {
		return ordersRepository.findAll();
	}

	public Orders findById(Long id) {
		Optional<Orders> optionalOrders = ordersRepository.findById(id);
		return optionalOrders.orElse(null);
	}

	public Orders save(Orders orders) {
		return ordersRepository.save(orders);
	}

	public Orders update(Orders orders) {
		Long id = orders.getId();
		if(id == null) {
			return null;
		}else {
			Orders findOrders = ordersRepository.findById(id).orElse(null);
			if(findOrders == null) {
				return null;
			}
			return ordersRepository.save(orders);
		}	
	}

	public void deleteById(Long id) {
		ordersRepository.deleteById(id);
		
	}

	
}
