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

import com.br.recode.restaurante.ladob.controller.mapper.ProductOrderMapper;
import com.br.recode.restaurante.ladob.dto.ProductOrderBaseDTO;
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
	public ResponseEntity<List<ProductOrderBaseDTO>> getAllProductOrder(@RequestParam Optional <String> name) {
		List<ProductOrder> productOrders = productOrderService.findAll();
		return new ResponseEntity<>(mapper.toProductOrderBaseDTO(productOrders), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductOrderBaseDTO> getProductOrderId(@PathVariable(value = "id") Long id) {
		ProductOrder productOrder = productOrderService.findById(id);
		if (productOrder == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(mapper.toProductOrderBaseDTO(productOrder), HttpStatus.OK);
		}

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductOrderBaseDTO> createProductOrder(@RequestBody  ProductOrderBaseDTO productOrderBaseDTO) {
		ProductOrder productOrderSaved = productOrderService.save(mapper.toProductOrder(productOrderBaseDTO));
		if (productOrderSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(mapper.toProductOrderBaseDTO(productOrderSaved), HttpStatus.CREATED);
		}
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductOrderBaseDTO> updateProductOrder(@PathVariable(value = "id") Long id,
			@RequestBody ProductOrderBaseDTO productOrderBaseDTO) {
		productOrderBaseDTO.setId(id);
		ProductOrder productOrderSaved = productOrderService.update(mapper.toProductOrder(productOrderBaseDTO));
		if (productOrderSaved == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(mapper.toProductOrderBaseDTO(productOrderSaved), HttpStatus.OK);
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
