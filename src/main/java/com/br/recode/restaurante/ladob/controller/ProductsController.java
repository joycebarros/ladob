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

import com.br.recode.restaurante.ladob.controller.mapper.ProductsMapper;
import com.br.recode.restaurante.ladob.dto.ProductsBaseDTO;
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
	public ResponseEntity<List<ProductsBaseDTO>> getAllProducts(@RequestParam Optional <String> name) {
		List<Products> products = productsService.findAll();
		return new ResponseEntity<>(mapper.toProductsBaseDTO(products), HttpStatus.OK);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ProductsBaseDTO> getProducts(@PathVariable(value = "id") Long id) {
		Products product = productsService.findById(id);
		if (product == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(mapper.toProductsBaseDTO(product), HttpStatus.OK);
		}

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductsBaseDTO> createTables(@RequestBody  ProductsBaseDTO productsBaseDTO) {
		Products productsSaved = productsService.save(mapper.toProducts(productsBaseDTO));
		if (productsSaved == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(mapper.toProductsBaseDTO(productsSaved), HttpStatus.CREATED);
		}

	}

	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductsBaseDTO> updateProducts(@PathVariable(value = "id") Long id,
			@RequestBody ProductsBaseDTO productsBaseDTO) {
		productsBaseDTO.setId(id);
		Products productsSaved = productsService.update(mapper.toProducts(productsBaseDTO));
		if (productsSaved == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(mapper.toProductsBaseDTO(productsSaved), HttpStatus.OK);
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
