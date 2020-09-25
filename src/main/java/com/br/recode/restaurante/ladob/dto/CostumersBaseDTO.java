package com.br.recode.restaurante.ladob.dto;

public class CostumersBaseDTO {

	private Long id;
	private String name;
	private String email;
	private String telephone;
	private OrdersBaseDTO order;
	
	public OrdersBaseDTO getOrder() {
		return order;
	}
	public void setOrder(OrdersBaseDTO order) {
		this.order = order;
	}
	public CostumersBaseDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
}
