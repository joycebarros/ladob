package com.br.recode.restaurante.ladob.service;

import org.springframework.stereotype.Service;

import com.br.recode.restaurante.ladob.repository.TablesRepository;

@Service
public class TablesService {

	private TablesRepository tablesRepository;

	public TablesService(TablesRepository tablesrepository) {
		super();
		this.tablesRepository = tablesrepository;
	}

}
