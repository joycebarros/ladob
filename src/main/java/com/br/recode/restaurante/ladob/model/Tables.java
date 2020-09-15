package com.br.recode.restaurante.ladob.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table (name = "tables")
public class Tables {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false, unique = true, length = 15)
	private String code;
	
	@Column(nullable= false)
	private Integer seats;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="tables", cascade= CascadeType.ALL)
	private List<Orders> orders;

	public Tables() {
		super();
	}

	public Tables(Integer id, String code, Integer seats) {
		super();
		this.id = id;
		this.code = code;
		this.seats = seats;
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

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

}
