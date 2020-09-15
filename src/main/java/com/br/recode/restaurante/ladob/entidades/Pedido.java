package com.br.recode.restaurante.ladob.entidades;

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
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
			
	@Column(name = "valor", nullable = false )
	private Double valor;

	@Column(name = "dataPedido", nullable = false, columnDefinition = "DATE")
	private Date dataPedido;
	
	@Column(name = "horaPedido", nullable = false, columnDefinition = "TIME")
	private Time horaPedido;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Mesa mesa;
	
	@ManyToOne(fetch=FetchType.EAGER, optional=false)
	private Cliente cliente;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="pedido", cascade= CascadeType.ALL)
	private List<PedidoProduto> pedidoProduto;
	
	public Pedido() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Double getValor() {
		return valor;
	}


	public void setValor(Double valor) {
		this.valor = valor;
	}


	public Date getDataPedido() {
		return dataPedido;
	}


	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}


	public Time getHoraPedido() {
		return horaPedido;
	}


	public void setHoraPedido(Time horaPedido) {
		this.horaPedido = horaPedido;
	}


	
}