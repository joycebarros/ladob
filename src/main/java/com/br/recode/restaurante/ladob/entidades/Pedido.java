package com.br.recode.restaurante.ladob.entidades;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
			
	@Column(name = "valor", nullable = false )
	private Double valor;

	@Temporal(TemporalType.DATE)
	@Column(name = "dataPedido", nullable = false)
	private Date dataPedido;
	
	//@Temporal(TemporalType.TIME)
	//@Column(name = "horaPedido", nullable = false)
	//private Time horaPedido;
	
		
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


	//public Time getHoraPedido() {
	//	return horaPedido;
	//}


	//public void setHoraPedido(Time horaPedido) {
	//	this.horaPedido = horaPedido;
	//}


	
}