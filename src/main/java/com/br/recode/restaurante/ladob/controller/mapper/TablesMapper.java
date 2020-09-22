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
		super();
		this.modelMapper = new ModelMapper();
	}
	
	public List<TablesBaseDTO> toTableBaseDTO(List<Tables> tables){
		List<TablesBaseDTO> tablesBaseDTO = new ArrayList<>();
		
		for (Tables table : tables) {
			tablesBaseDTO.add(toTableBaseDTO(table));			
		}
		return tablesBaseDTO;
	}
	
	public TablesBaseDTO toTableBaseDTO(Tables tables) {
		return modelMapper.map(tables, TablesBaseDTO.class);
	}
	
	public Tables toTable(TablesBaseDTO tablesBaseDTO) {
		return modelMapper.map(tablesBaseDTO, Tables.class);
	}
	
	
	

}
