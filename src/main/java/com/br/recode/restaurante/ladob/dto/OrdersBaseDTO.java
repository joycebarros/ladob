package com.br.recode.restaurante.ladob.dto;

import java.sql.Time;
import java.util.Date;

public class OrdersBaseDTO {

	private Long id;
	private Double totalAmount;
	private Date orderDate;
	private Time orderTime;
	private TablesBaseDTO tables;
	private CostumersBaseDTO costumers;
	private ProductOrderBaseDTO producterOrder;
	
	public OrdersBaseDTO() {
		super();
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
	public ProductOrderBaseDTO getProducterOrder() {
		return producterOrder;
	}
	public void setProducterOrder(ProductOrderBaseDTO producterOrder) {
		this.producterOrder = producterOrder;
	}
	
	
}
