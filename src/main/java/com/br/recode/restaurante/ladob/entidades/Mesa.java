package com.br.recode.restaurante.ladob.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Mesa")
public class Mesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String codigo;
	
	@Column
	private Integer cadeiras;

	public Mesa() {
		super();
	}

	public Mesa(Long id, String codigo, Integer cadeiras) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.cadeiras = cadeiras;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getCadeiras() {
		return cadeiras;
	}

	public void setCadeiras(Integer cadeiras) {
		this.cadeiras = cadeiras;
	}

}
