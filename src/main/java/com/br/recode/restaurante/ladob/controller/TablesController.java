package com.br.recode.restaurante.ladob.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.recode.restaurante.ladob.model.Tables;
import com.br.recode.restaurante.ladob.service.TablesService;

@RestController
@RequestMapping (path = "/tables", produces = MediaType.APPLICATION_JSON_VALUE)
public class TablesController {

private TablesService tablesService;
	
	public TablesController(TablesService tablesService) {
		super();
		this.tablesService = tablesService;
	}
	
	@GetMapping
	public ResponseEntity<List<Tables>> getAllTables(){
		List<Tables> tables = tablesService.findAll();
		return new ResponseEntity <>(tables, HttpStatus.OK);
	}
	
	@GetMapping(value="/{table_id}")
	public ResponseEntity<Tables> getTableId(@PathVariable (value="table_id") Integer id){
		Tables table = tablesService.findById(id);
		if (table ==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(table, HttpStatus.OK);
		}
			
	}
		
}
