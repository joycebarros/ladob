package com.br.recode.restaurante.ladob.dto;

public class TablesBaseDTO {

	private Integer id;
	private String code;
	private Integer seats;
	private OrdersBaseDTO orders;
	
	public TablesBaseDTO() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Integer getSeats() {
		return seats;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	public OrdersBaseDTO getOrders() {
		return orders;
	}
	public void setOrders(OrdersBaseDTO orders) {
		this.orders = orders;
	}
	
}
