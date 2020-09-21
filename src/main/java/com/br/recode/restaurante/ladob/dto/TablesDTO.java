package com.br.recode.restaurante.ladob.dto;

import java.util.List;

public class TablesDTO extends TablesBaseDTO {

	private List<OrdersBaseDTO> orders;
	
	public TablesDTO() {
		
	}

	public List<OrdersBaseDTO> getOrders() {
		return orders;
	}

	public void setOrders(List<OrdersBaseDTO> orders) {
		this.orders = orders;
	}
	
	
}
