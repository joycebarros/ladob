package com.br.recode.restaurante.ladob.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.recode.restaurante.ladob.model.Costumers;
import com.br.recode.restaurante.ladob.repository.CostumersRepository;

@Service
public class CostumersService {

	private CostumersRepository costumersRepository;
	
	public CostumersService(CostumersRepository costumersRepository) {
		super();
		this.costumersRepository = costumersRepository;
	}

	public List<Costumers> findAll() {
		return costumersRepository.findAll();
	}
	
}
