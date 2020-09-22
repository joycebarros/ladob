package com.br.recode.restaurante.ladob.service;

import java.util.List;
import java.util.Optional;

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

	public Tables save(Tables table) {
		table.setId(null);
		return tablesRepository.save(table);
	}
	
	

}
