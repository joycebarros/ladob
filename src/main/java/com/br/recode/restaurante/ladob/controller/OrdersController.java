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

import com.br.recode.restaurante.ladob.controller.mapper.OrdersMapper;
import com.br.recode.restaurante.ladob.dto.OrdersBaseDTO;
import com.br.recode.restaurante.ladob.dto.OrdersDTO;
import com.br.recode.restaurante.ladob.model.Orders;
import com.br.recode.restaurante.ladob.service.OrdersService;

@RestController
@RequestMapping (path = "/orders",  produces = MediaType.APPLICATION_JSON_VALUE)
public class OrdersController {

	private OrdersService ordersService;
	private OrdersMapper mapper;

	public OrdersController(OrdersService ordersService, OrdersMapper mapper) {
		super();
		this.ordersService = ordersService;
		this.mapper = mapper;
	}
	
	
	@GetMapping
	public ResponseEntity<List<OrdersBaseDTO>> getAllOrders(){
		List <Orders> orders = ordersService.findAll();
		return new ResponseEntity<>(mapper.toOrdersBaseDTO(orders), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrdersDTO> getOrderId(@PathVariable (value = "id") Long id){
		Orders orders = ordersService.findById(id);
		if (orders == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(mapper.toOrdersDTO(orders), HttpStatus.OK);
		}			
		
	}
	
	@PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrdersBaseDTO> createOrders (@RequestBody OrdersBaseDTO ordersBaseDTO){
		Orders orders = ordersService.save(mapper.toOrders(ordersBaseDTO));
		if(orders == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>(mapper.toOrdersBaseDTO(orders), HttpStatus.CREATED);
		}
	}
	
	@PutMapping (value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrdersBaseDTO> updateOrder (@PathVariable (value = "id") Long id,
			@RequestBody OrdersBaseDTO ordersBaseDTO){
		ordersBaseDTO.setId(id);
		Orders orders = ordersService.update(mapper.toOrders(ordersBaseDTO));
		if(orders == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(mapper.toOrdersBaseDTO(orders), HttpStatus.OK);
		}
	}
	
	@DeleteMapping (value = "/{id}")
	public ResponseEntity<Void> deleteOrderId (@PathVariable (value = "id") Long id){
		ordersService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
