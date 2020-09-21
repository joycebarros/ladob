package com.br.recode.restaurante.ladob.controller.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.br.recode.restaurante.ladob.dto.CostumersBaseDTO;
import com.br.recode.restaurante.ladob.dto.CostumersDTO;
import com.br.recode.restaurante.ladob.model.Costumers;

@Component
public class CostumersMapper {

	private ModelMapper modelMapper;

	public CostumersMapper() {
		this.modelMapper = new ModelMapper();
	}

	public List<CostumersBaseDTO> toCostumersBaseDTO(List<Costumers> costumers) {
		List<CostumersBaseDTO> costumersBaseDTO = new ArrayList<>();

		for (Costumers costumer : costumers) {
			costumersBaseDTO.add(toCostumersBaseDTO(costumer));
		}
		return costumersBaseDTO;
	}

	public CostumersBaseDTO toCostumersBaseDTO(Costumers costumer) {
		return modelMapper.map(costumer, CostumersBaseDTO.class);
	}

	public CostumersDTO toCostumersDTO(Costumers costumer) {
		return modelMapper.map(costumer, CostumersDTO.class);
	}

	public Costumers toCostumers(CostumersBaseDTO costumersBaseDTO) {
		return modelMapper.map(costumersBaseDTO, Costumers.class);
	}
}
