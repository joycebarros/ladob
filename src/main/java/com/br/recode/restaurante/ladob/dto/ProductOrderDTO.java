package com.br.recode.restaurante.ladob.dto;

public class ProductOrderDTO extends ProductOrderBaseDTO {

	private OrdersBaseDTO orders;
	private ProductsBaseDTO products;
	
	public ProductOrderDTO() {
		
	}

	public OrdersBaseDTO getOrders() {
		return orders;
	}

	public void setOrders(OrdersBaseDTO orders) {
		this.orders = orders;
	}

	public ProductsBaseDTO getProducts() {
		return products;
	}

	public void setProducts(ProductsBaseDTO products) {
		this.products = products;
	}
	
	
}
