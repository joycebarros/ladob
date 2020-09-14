package com.br.recode.restaurante.ladob.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="pedido_produto")


public class pedido_produto {
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public pedido_produto() {
		super();
	}

	public pedido_produto(Long id, Integer quantidade) {
		super();
		this.id = id;
		this.quantidade = quantidade;
	}

	@Id 
	@Column 
	private Long id;
	
	@Column
	private Integer quantidade ;
}
