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

import com.br.recode.restaurante.ladob.controller.mapper.ProductsMapper;
import com.br.recode.restaurante.ladob.model.Products;
import com.br.recode.restaurante.ladob.service.ProductsService;

@RestController
@RequestMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductsController {

	private ProductsService productsService;
	private ProductsMapper mapper;

	public ProductsController(ProductsService productsService, ProductsMapper mapper) {
		super();
		this.productsService = productsService;
		this.mapper = mapper;
	}

	@GetMapping
	public ResponseEntity<List<Products>> getAllProducts() {
		List<Products> products = productsService.findAll();
		return new ResponseEntity<>(products, HttpStatus.OK);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Products> getProducts(@PathVariable(value = "id") Long id) {
		Products products = productsService.findById(id);
		if (products == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(products, HttpStatus.OK);
		}

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Products> createTables(@RequestBody Products products) {
		Products productsSaved = productsService.save(products);
		if (productsSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(productsSaved, HttpStatus.CREATED);
		}

	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Products> updateProducts(@PathVariable(value = "id") Long id,
			@RequestBody Products products) {
		products.setId(id);
		Products productsSaved = productsService.update(products);
		if (productsSaved == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(productsSaved, HttpStatus.OK);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable(value = "id") Long id) {
		productsService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteProducts() {
		productsService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}
}
