package com.br.recode.restaurante.ladob.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.br.recode.restaurante.ladob.controller.mapper.TablesMapper;
import com.br.recode.restaurante.ladob.model.Tables;
import com.br.recode.restaurante.ladob.service.TablesService;

@RestController
@RequestMapping(path = "/tables", produces = MediaType.APPLICATION_JSON_VALUE)
public class TablesController {

	private TablesService tablesService;
	private TablesMapper mapper;

	public TablesController(TablesService tablesService, TablesMapper mapper) {
		this.tablesService = tablesService;
		this.mapper = mapper;
	}

	@GetMapping
	public ResponseEntity<List<Tables>> getTables() {
		List<Tables> tables = tablesService.findAll();
		return new ResponseEntity<>(tables, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Tables> getTable(@PathVariable(value = "id") Integer id) {
		Tables table = tablesService.findById(id);
		if (table == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(table, HttpStatus.OK);
		}

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> createTables(@RequestBody Tables tables) {
		Tables tablesSaved = tablesService.save(tables);
		if (tablesSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(tablesSaved, HttpStatus.CREATED);
		}
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Tables> updateTables(@PathVariable(value = "id") Integer id, @RequestBody Tables tables) {
		tables.setId(id);
		Tables tablesSaved = tablesService.update(tables);
		if (tablesSaved == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(tablesSaved, HttpStatus.OK);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteTable(@PathVariable(value = "id") Integer id) {
		tablesService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteTables() {
		tablesService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}
}
