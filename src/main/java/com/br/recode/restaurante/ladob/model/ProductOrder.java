package com.br.recode.restaurante.ladob.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="productOrder")
public class ProductOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Integer quantity;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Orders orders;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Products products;
	
	public ProductOrder() {
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

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	
}
