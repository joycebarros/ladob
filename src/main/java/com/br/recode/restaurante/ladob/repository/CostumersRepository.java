package com.br.recode.restaurante.ladob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.recode.restaurante.ladob.model.Costumers;
import com.br.recode.restaurante.ladob.model.Orders;


@Repository
public interface CostumersRepository  extends JpaRepository<Costumers, Long>{
	
	List<Orders> findByNameContainingIgnoreCase(String name);

}
