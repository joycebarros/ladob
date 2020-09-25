package com.br.recode.restaurante.ladob.controller.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.br.recode.restaurante.ladob.dto.TablesBaseDTO;
import com.br.recode.restaurante.ladob.model.Tables;

@Component
public class TablesMapper {

	private ModelMapper modelMapper;

	public TablesMapper() {
		this.modelMapper = new ModelMapper();
	}

	public List<TablesBaseDTO> toTablesBaseDTO(List<Tables> tables) {
		List<TablesBaseDTO> tablesBaseDTO = new ArrayList<>();

		for (Tables table : tables) {
			tablesBaseDTO.add(toTablesBaseDTO(table));
		}
		return tablesBaseDTO;
	}

	public TablesBaseDTO toTablesBaseDTO(Tables table) {
		return modelMapper.map(table, TablesBaseDTO.class);
	}

	public Tables toTables(TablesBaseDTO tablesBaseDTO) {
		return modelMapper.map(tablesBaseDTO, Tables.class);
	}
}
