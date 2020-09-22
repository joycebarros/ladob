package com.br.recode.restaurante.ladob.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.recode.restaurante.ladob.controller.mapper.TablesMapper;
import com.br.recode.restaurante.ladob.dto.TablesBaseDTO;
import com.br.recode.restaurante.ladob.model.Tables;
import com.br.recode.restaurante.ladob.service.TablesService;

@RestController
@RequestMapping (path = "/tables", produces = MediaType.APPLICATION_JSON_VALUE)
public class TablesController {

private TablesService tablesService;
private TablesMapper tablesMapper;	

	public TablesController(TablesService tablesService, TablesMapper tablesMapper) {
		super();
		this.tablesService = tablesService;
		this.tablesMapper = tablesMapper;
	}
	
	@GetMapping
	public ResponseEntity<List<TablesBaseDTO>> getAllTables(){
		List<Tables> tables = tablesService.findAll();
		return new ResponseEntity<>(tablesMapper.toTableBaseDTO(tables), HttpStatus.OK);
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
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TablesBaseDTO> createTables(@RequestBody TablesBaseDTO tablesBaseDTO ){
		Tables tables = tablesService.save(tablesMapper.toTable(tablesBaseDTO));
		if(tables == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>(tablesMapper.toTableBaseDTO(tables), HttpStatus.CREATED);
		}
	}
		
}
