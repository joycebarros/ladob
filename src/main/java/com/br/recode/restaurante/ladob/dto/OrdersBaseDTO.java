package com.br.recode.restaurante.ladob.dto;

import java.sql.Time;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrdersBaseDTO {

	private Long id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
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
