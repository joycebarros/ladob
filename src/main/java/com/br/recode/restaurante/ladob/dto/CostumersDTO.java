package com.br.recode.restaurante.ladob.dto;

import java.util.List;

public class CostumersDTO extends CostumersBaseDTO {
	
	private List<OrdersBaseDTO> orders;
	
	public CostumersDTO() {
		
	}

	public List<OrdersBaseDTO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrdersBaseDTO> orders) {
		this.orders = orders;
	}
	
	

}
