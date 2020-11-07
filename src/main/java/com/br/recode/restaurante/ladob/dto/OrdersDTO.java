package com.br.recode.restaurante.ladob.dto;

import java.util.List;

public class OrdersDTO extends OrdersBaseDTO {

	private List<ProductOrderBaseDTO> productOrder;
	
	public OrdersDTO() {
		
	}
	
	public List<ProductOrderBaseDTO> getProductOrder() {
		return productOrder;
	}

	public void setProductOrder(List<ProductOrderBaseDTO> productOrder) {
		this.productOrder = productOrder;
	}
	
	
}
