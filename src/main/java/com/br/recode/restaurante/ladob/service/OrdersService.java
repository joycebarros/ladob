package com.br.recode.restaurante.ladob.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
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
		orders.setId(null);
		return internalSave(orders);
	}

	public Orders update(Orders orders) {
		Long id = orders.getId();
		if (id == null) {
			return null;
		}
		if (!ordersRepository.existsById(id)) {
			return null;
		}
		return internalSave(orders);
	}

	public void deleteById(Long id) {
		try {
			ordersRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

	public void deleteAll() {
		ordersRepository.deleteAllInBatch();
	}

	public Orders internalSave(Orders orders) {
		try {
			return ordersRepository.save(orders);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
