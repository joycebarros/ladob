package com.br.recode.restaurante.ladob.dto;

public class ProductOrderBaseDTO {

	private Long id;
	private Integer quantity;
	
	public ProductOrderBaseDTO() {
		
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
	
	
}
