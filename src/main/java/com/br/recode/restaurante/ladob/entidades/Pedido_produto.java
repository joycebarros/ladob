package com.br.recode.restaurante.ladob.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="pedido_produto")


public class Pedido_produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Integer quantidade ;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Pedido pedido;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Produto produto;
		
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

	public Pedido_produto() {
		super();
	}

	public Pedido_produto(Long id, Integer quantidade) {
		super();
		this.id = id;
		this.quantidade = quantidade;
	}

	
}
