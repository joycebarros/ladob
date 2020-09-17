package com.br.recode.restaurante.ladob.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.recode.restaurante.ladob.service.CostumersService;

@RestController
@RequestMapping (path = "/costumers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CostumersController {

	private CostumersService costumersService;
	
	public CostumersController(CostumersService costumersService) {
		super();
		this.costumersService = costumersService;
	}
	
}
