package com.br.recode.restaurante.ladob.dto;

import java.sql.Time;
import java.util.Date;

public class OrdersBaseDTO {

	private Long id;
	private Date orderDate;
	private Time orderTime;
	private TablesBaseDTO tables;
	private CostumersBaseDTO costumers;
	
	public OrdersBaseDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
}
