package com.br.recode.restaurante.ladob.dto;

public class ProductOrderBaseDTO {

	private Long id;
	private Integer quantity;
	private ProductsBaseDTO products;
	private OrdersBaseDTO orders;
	
	public ProductOrderBaseDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public ProductsBaseDTO getProducts() {
		return products;
	}
	public void setProducts(ProductsBaseDTO products) {
		this.products = products;
	}
	public OrdersBaseDTO getOrders() {
		return orders;
	}
	public void setOrders(OrdersBaseDTO orders) {
		this.orders = orders;
	}
	
	
}
