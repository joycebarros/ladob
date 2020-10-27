package com.br.recode.restaurante.ladob.dto;

import java.sql.Time;
import java.util.Date;

public class OrdersBaseDTO {

	private Long id;
	private Double totalAmount;
	private Date orderDate;
	private Time orderTime;
	
	public OrdersBaseDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Time getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Time orderTime) {
		this.orderTime = orderTime;
	}
	
	
}
