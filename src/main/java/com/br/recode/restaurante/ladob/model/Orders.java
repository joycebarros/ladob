package com.br.recode.restaurante.ladob.model;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
			
	@Column(nullable = false )
	private Double totalAmount;

	@Column(nullable = false, columnDefinition = "DATE")
	private Date orderDate;
	
	@Column(nullable = false, columnDefinition = "TIME")
	private Time orderTime;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Tables tables;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Costumers costumers;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="orders", cascade= CascadeType.ALL)
	private List<ProductOrder> productOrder;
	
	public Orders() {
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


	public void setOrderDater(Date orderDate) {
		this.orderDate = orderDate;
	}


	public Time getOrderTime() {
		return orderTime;
	}


	public void setOrderTime(Time orderTime) {
		this.orderTime = orderTime;
	}


	public Tables getTables() {
		return tables;
	}


	public void setTables(Tables tables) {
		this.tables = tables;
	}


	public Costumers getCostumers() {
		return costumers;
	}


	public void setCostumers(Costumers costumers) {
		this.costumers = costumers;
	}


	public List<ProductOrder> getProductOrder() {
		return productOrder;
	}


	public void setProductOrder(List<ProductOrder> productOrder) {
		this.productOrder = productOrder;
	}
	
}