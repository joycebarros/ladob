/*package com.br.recode.restaurante.ladob.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.recode.restaurante.ladob.model.Costumers;
import com.br.recode.restaurante.ladob.service.CostumersService;

@RestController
@RequestMapping (path = "/costumers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CostumersController {

	private CostumersService costumersService;
	
	public CostumersController(CostumersService costumersService) {
		super();
		this.costumersService = costumersService;
	}
	
	@GetMapping
	public ResponseEntity<List<Costumers>> getAllCostumers(){
		List <Costumers> costumers = costumersService.findAll();
		return new ResponseEntity<>(costumers, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{costumers_id}")
	public ResponseEntity<Costumers> getCostumer(@PathVariable (value = "costumer_id") Long id){
		Costumers costumer = costumersService.findById(id);
		if (costumer == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
}*/
