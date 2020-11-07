package com.br.recode.restaurante.ladob.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.recode.restaurante.ladob.model.Costumers;
import com.br.recode.restaurante.ladob.model.Orders;
import com.br.recode.restaurante.ladob.model.Tables;
import com.br.recode.restaurante.ladob.repository.OrdersRepository;

@Service
public class OrdersService {
	
	private OrdersRepository ordersRepository;
	private CostumersService costumersService;
	private TablesService tablesService;

	public OrdersService(OrdersRepository ordersRepository, CostumersService costumersService, TablesService tablesService) {
		super();
		this.ordersRepository = ordersRepository;
		this.costumersService = costumersService;
		this.tablesService = tablesService;		
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
		
		try{
			orders = ordersRepository.save(orders);
			Costumers costumers = costumersService.findById(orders.getCostumers().getId());
			orders.setCostumers(costumers);
			Tables tables = tablesService.findById(orders.getTables().getId());
			orders.setTables(tables);
			return orders;
			
		}catch (Exception e) {
			return null;
		}		
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
