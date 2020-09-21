package com.br.recode.restaurante.ladob.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.br.recode.restaurante.ladob.model.Tables;
import com.br.recode.restaurante.ladob.repository.TablesRepository;

@Service
public class TablesService {

	private TablesRepository tablesRepository;

	public TablesService(TablesRepository tablesrepository) {
		super();
		this.tablesRepository = tablesrepository;
	}

	public List<Tables> findAll() {
		return tablesRepository.findAll();
	}

	public Tables findById(Integer id) {
		Optional<Tables> optionalTables = tablesRepository.findById(id);
		return optionalTables.orElse(null);
	}

	public Tables save(Tables tables) {
		tables.setId(null);
		return internalSave(tables);
	}

	public Tables update(Tables tables) {
		Integer id = tables.getId();
		if (id == null) {
			return null;
		}
		if (!tablesRepository.existsById(id)) {
			return null;
		}
		return internalSave(tables);
	}

	public void deleteById(Integer id) {
		try {
			tablesRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

	public void deleteAll() {
		tablesRepository.deleteAllInBatch();
	}

	public Tables internalSave(Tables tables) {
		try {
			return tablesRepository.save(tables);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
