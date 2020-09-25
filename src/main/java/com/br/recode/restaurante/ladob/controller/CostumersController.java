package com.br.recode.restaurante.ladob.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.recode.restaurante.ladob.controller.mapper.CostumersMapper;
import com.br.recode.restaurante.ladob.dto.CostumersBaseDTO;
import com.br.recode.restaurante.ladob.model.Costumers;
import com.br.recode.restaurante.ladob.service.CostumersService;

@RestController
@RequestMapping(path = "/costumers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CostumersController {

	private CostumersService costumersService;
	private CostumersMapper mapper;

	public CostumersController(CostumersService costumersService, CostumersMapper mapper) {
		this.costumersService = costumersService;
		this.mapper = mapper;
	}

	@GetMapping
	public ResponseEntity<List<CostumersBaseDTO>> getAllCostumers(@RequestParam Optional <String> name) {
		List<Costumers> costumers = costumersService.findAll();
		return new ResponseEntity<>(mapper.toCostumersBaseDTO(costumers), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CostumersBaseDTO> getCostumerId(@PathVariable(value = "id") Long id) {
		Costumers costumer = costumersService.findById(id);
		if (costumer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(mapper.toCostumersBaseDTO(costumer), HttpStatus.OK);
		}

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CostumersBaseDTO> createCostumers(@RequestBody CostumersBaseDTO costumersBaseDTO) {
		Costumers costumersSaved = costumersService.save(mapper.toCostumers(costumersBaseDTO));
		if (costumersSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(mapper.toCostumersBaseDTO(costumersSaved), HttpStatus.CREATED);
		}
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CostumersBaseDTO> updateCostumers(@PathVariable(value = "id") Long id,
			@RequestBody CostumersBaseDTO costumersBaseDTO) {
		costumersBaseDTO.setId(id);
		Costumers costumersSaved = costumersService.update(mapper.toCostumers(costumersBaseDTO));
		if (costumersSaved == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(mapper.toCostumersBaseDTO(costumersSaved), HttpStatus.OK);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteCostumer(@PathVariable(value = "id") Long id) {
		costumersService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteCostumers() {
		costumersService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}
}
