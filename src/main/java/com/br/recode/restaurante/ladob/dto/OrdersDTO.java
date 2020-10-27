package com.br.recode.restaurante.ladob.dto;

import java.util.List;

public class OrdersDTO extends OrdersBaseDTO {

	private TablesBaseDTO tables;
	private CostumersBaseDTO costumers;
	private List<ProductOrderBaseDTO> productOrder;
	
	public OrdersDTO() {
		
	}

	public TablesBaseDTO getTables() {
		return tables;
	}

	public void setTables(TablesBaseDTO tables) {
		this.tables = tables;
	}

	public CostumersBaseDTO getCostumers() {
		return costumers;
	}

	public void setCostumers(CostumersBaseDTO costumers) {
		this.costumers = costumers;
	}

	public List<ProductOrderBaseDTO> getProductOrder() {
		return productOrder;
	}

	public void setProductOrder(List<ProductOrderBaseDTO> productOrder) {
		this.productOrder = productOrder;
	}
	
	
}
