package com.br.recode.restaurante.ladob.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.recode.restaurante.ladob.model.Products;
import com.br.recode.restaurante.ladob.service.ProductsService;

@RestController
@RequestMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductsController {
	
	private ProductsService productsService;
	
	public ProductsController(ProductsService productsService) {
		super();
		this.productsService = productsService;
	}
	
	@GetMapping
	public ResponseEntity<List<Products>> getAllProducts(){
	List<Products> products = productsService.findAll();
	return new ResponseEntity <>(products, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Products> getProducts(@PathVariable (value = "id") Long id){
		Products products = productsService.findById(id);
		if (products == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(products, HttpStatus.OK);
		}	
		
	}

	


}
