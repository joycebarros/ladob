package com.br.recode.restaurante.ladob.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.br.recode.restaurante.ladob.model.Costumers;
import com.br.recode.restaurante.ladob.repository.CostumersRepository;

@Service
public class CostumersService {

	private CostumersRepository costumersRepository;

	public CostumersService(CostumersRepository costumersRepository) {
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
		return internalSave(costumers);
	}

	public Costumers update(Costumers costumers) {
		Long id = costumers.getId();
		if (id == null) {
			return null;
		}
		if (!costumersRepository.existsById(id)) {
			return null;
		}
		return internalSave(costumers);
	}

	public void deleteById(Long id) {
		try {
			costumersRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

	public void deleteAll() {
		costumersRepository.deleteAllInBatch();
	}

	public Costumers internalSave(Costumers costumers) {
		try {
			return costumersRepository.save(costumers);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
