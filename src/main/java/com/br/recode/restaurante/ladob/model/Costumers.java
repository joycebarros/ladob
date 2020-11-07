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

import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "costumers")
public class Costumers {

	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 40 )
	private String name;
	
	@Column(nullable = false, unique = true, length = 40 )
	private String email;
	
	@Column(nullable = false, unique = true, length = 11)
	private String telephone;
	
	@Column(nullable = false, length = 100 )
	private String password;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="costumers", cascade= CascadeType.ALL)
	private List<Orders> orders;
	
	public Costumers() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		String salt = BCrypt.gensalt();
		this.password = BCrypt.hashpw(password, salt);
//		this.password = password;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	public boolean validarSenha(String password) {
		return BCrypt.checkpw(password, this.getPassword());
	}
}
