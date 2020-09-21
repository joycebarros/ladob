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

import com.br.recode.restaurante.ladob.controller.mapper.ProductOrderMapper;
import com.br.recode.restaurante.ladob.model.ProductOrder;
import com.br.recode.restaurante.ladob.service.ProductOrderService;

@RestController
@RequestMapping(path = "/productOrder", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductOrderController {

	private ProductOrderService productOrderService;
	private ProductOrderMapper mapper;

	public ProductOrderController(ProductOrderService productOrderService, ProductOrderMapper mapper) {
		this.productOrderService = productOrderService;
		this.mapper = mapper;
	}

	@GetMapping
	public ResponseEntity<List<ProductOrder>> getAllProductOrder() {
		List<ProductOrder> productOrder = productOrderService.findAll();
		return new ResponseEntity<>(productOrder, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductOrder> getProductOrderId(@PathVariable(value = "id") Long id) {
		ProductOrder productOrder = productOrderService.findById(id);
		if (productOrder == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(productOrder, HttpStatus.OK);
		}

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductOrder> createProductOrder(@RequestBody ProductOrder productOrder) {
		ProductOrder productOrderSaved = productOrderService.save(productOrder);
		if (productOrderSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(productOrderSaved, HttpStatus.CREATED);
		}
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductOrder> updateProductOrder(@PathVariable(value = "id") Long id,
			@RequestBody ProductOrder productOrder) {
		productOrder.setId(id);
		ProductOrder productOrderSaved = productOrderService.update(productOrder);
		if (productOrderSaved == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(productOrderSaved, HttpStatus.OK);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteProductOrder(@PathVariable(value = "id") Long id) {
		productOrderService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteProductOrder() {
		productOrderService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}
}
