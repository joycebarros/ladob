package com.br.recode.restaurante.ladob.controller.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.br.recode.restaurante.ladob.dto.OrdersBaseDTO;
import com.br.recode.restaurante.ladob.model.Orders;

@Component
public class OrdersMapper {

	private ModelMapper modelMapper;

	public OrdersMapper() {
		this.modelMapper = new ModelMapper();
	}

	public List<OrdersBaseDTO> toOrdersBaseDTO(List<Orders> orders) {
		List<OrdersBaseDTO> ordersBaseDTO = new ArrayList<>();

		for (Orders order : orders) {
			ordersBaseDTO.add(toOrdersBaseDTO(order));
		}
		return ordersBaseDTO;
	}

	public OrdersBaseDTO toOrdersBaseDTO(Orders order) {
		return modelMapper.map(order, OrdersBaseDTO.class);
	}

	public Orders toOrders(OrdersBaseDTO ordersBaseDTO) {
		return modelMapper.map(ordersBaseDTO, Orders.class);
	}
}
