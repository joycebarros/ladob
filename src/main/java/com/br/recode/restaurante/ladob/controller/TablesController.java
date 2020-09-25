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

import com.br.recode.restaurante.ladob.controller.mapper.TablesMapper;
import com.br.recode.restaurante.ladob.dto.TablesBaseDTO;
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
	public ResponseEntity<List<TablesBaseDTO>> getTables(@RequestParam Optional <String> name) {
		List<Tables> tables = tablesService.findAll();
		return new ResponseEntity<>(mapper.toTablesBaseDTO(tables), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<TablesBaseDTO> getTable(@PathVariable(value = "id") Integer id) {
		Tables table = tablesService.findById(id);
		if (table == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(mapper.toTablesBaseDTO(table), HttpStatus.OK);
		}

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TablesBaseDTO> createTables(@RequestBody TablesBaseDTO tablesBaseDTO ) {
		Tables tablesSaved = tablesService.save(mapper.toTables(tablesBaseDTO));
		if (tablesSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(mapper.toTablesBaseDTO(tablesSaved), HttpStatus.CREATED);
		}
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TablesBaseDTO> updateTables(@PathVariable(value = "id") Integer id, @RequestBody TablesBaseDTO tablesBaseDTO) {
		tablesBaseDTO.setId(id);
		Tables tablesSaved = tablesService.update(mapper.toTables(tablesBaseDTO));
		if (tablesSaved == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(mapper.toTablesBaseDTO(tablesSaved), HttpStatus.OK);
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
