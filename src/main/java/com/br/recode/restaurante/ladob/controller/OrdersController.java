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

import com.br.recode.restaurante.ladob.controller.mapper.OrdersMapper;
import com.br.recode.restaurante.ladob.dto.OrdersBaseDTO;
import com.br.recode.restaurante.ladob.model.Orders;
import com.br.recode.restaurante.ladob.service.OrdersService;

@RestController
@RequestMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrdersController {

	private OrdersService ordersService;
	private OrdersMapper mapper;

	public OrdersController(OrdersService ordersService, OrdersMapper mapper) {
		this.ordersService = ordersService;
		this.mapper = mapper;
	}

	@GetMapping
	public ResponseEntity<List<OrdersBaseDTO>> getAllOrders(@RequestParam Optional <String> name) {
		List<Orders> orders = ordersService.findAll();
		return new ResponseEntity<>(mapper.toOrdersBaseDTO(orders), HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<OrdersBaseDTO> getOrderId(@PathVariable(value = "id") Long id) {
		Orders order = ordersService.findById(id);
		if (order == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(mapper.toOrdersBaseDTO(order), HttpStatus.OK);
		}

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrdersBaseDTO> createOrders(@RequestBody OrdersBaseDTO ordersBaseDTO) {
		Orders ordersSaved = ordersService.save(mapper.toOrders(ordersBaseDTO));
		if (ordersSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(mapper.toOrdersBaseDTO(ordersSaved), HttpStatus.CREATED);
		}
	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrdersBaseDTO> updateOrders(@PathVariable(value = "id") Long id, @RequestBody OrdersBaseDTO ordersBaseDTO) {
		ordersBaseDTO.setId(id);
		Orders ordersSaved = ordersService.update(mapper.toOrders(ordersBaseDTO));
		if (ordersSaved == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(mapper.toOrdersBaseDTO(ordersSaved), HttpStatus.OK);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable(value = "id") Long id) {
		ordersService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping
	public ResponseEntity<Void> deleteOrders() {
		ordersService.deleteAll();
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	}
}
