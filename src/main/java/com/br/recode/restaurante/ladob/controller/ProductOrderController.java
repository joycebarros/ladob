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
import com.br.recode.restaurante.ladob.dto.ProductOrderBaseDTO;
import com.br.recode.restaurante.ladob.dto.ProductOrderDTO;
import com.br.recode.restaurante.ladob.model.ProductOrder;
import com.br.recode.restaurante.ladob.service.ProductOrderService;

@RestController
@RequestMapping (path = "/productorder", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductOrderController {
	
	private ProductOrderService productOrderService;
	private ProductOrderMapper mapper;
	
	public ProductOrderController(ProductOrderService productOrderService, ProductOrderMapper mapper) {
		super();
		this.productOrderService = productOrderService;
		this.mapper = mapper;
	}

	@GetMapping
	public ResponseEntity<List<ProductOrderBaseDTO>> getAllProductOrder(){
		List <ProductOrder> productOrder = productOrderService.findAll();
		return new ResponseEntity<>(mapper.toProductOrderBaseDTO(productOrder), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductOrderDTO> getProductOrderId(@PathVariable (value = "id") Long id){
		ProductOrder productOrder = productOrderService.findById(id);
		if (productOrder == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(mapper.toProductOrderDTO(productOrder), HttpStatus.OK);
		}			
		
	}
	
	@PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductOrderBaseDTO> createProductOrder (@RequestBody ProductOrderBaseDTO productOrderBaseDTO){
		ProductOrder productOrder = productOrderService.save(mapper.toProductOrder(productOrderBaseDTO));
		if(productOrder == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>(mapper.toProductOrderBaseDTO(productOrder), HttpStatus.CREATED);
		}
	}
	
	@PutMapping (value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductOrderBaseDTO> updateProductOrder (@PathVariable (value = "id") Long id,
			@RequestBody ProductOrderBaseDTO productOrderBaseDTO){
		productOrderBaseDTO.setId(id);
		ProductOrder productOrder = productOrderService.update(mapper.toProductOrder(productOrderBaseDTO));
		if(productOrder == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(mapper.toProductOrderBaseDTO(productOrder), HttpStatus.OK);
		}
	}
	
	@DeleteMapping (value = "/{id}")
	public ResponseEntity<Void> deleteProductOrderId (@PathVariable (value = "id") Long id){
		productOrderService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
