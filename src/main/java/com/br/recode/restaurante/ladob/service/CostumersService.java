package com.br.recode.restaurante.ladob.service;

import java.util.List;
import java.util.Optional;

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

	public Costumers findById(Long id) {
		Optional<Costumers> optionalCostumers = costumersRepository.findById(id);
		return optionalCostumers.orElse(null);
	}

	public Costumers save(Costumers costumers) {
		costumers.setId(null);
		return costumersRepository.save(costumers);
	}

	public Costumers update(Costumers costumers) {
		Long id = costumers.getId();
		if (id == null) {
			return null;
		} else {
			Costumers findCostumers = costumersRepository.findById(id).orElse(null);
			if (findCostumers == null) {
				return null;
			}
			return costumersRepository.save(costumers);
		}
	}

	public void deleteById(Long id) {
		costumersRepository.deleteById(id);

	}

	public Costumers findByEmail(String email) {
		return costumersRepository.findByEmail(email);
	}

}
