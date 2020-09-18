package com.br.recode.restaurante.ladob.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.recode.restaurante.ladob.model.Products;
import com.br.recode.restaurante.ladob.repository.ProductsRepository;

@Service
public class ProductsService {
	
	//referenciar o repositorio ao servico prodto
	private ProductsRepository productsRepository;
	
	//criacao do construtor
	public ProductsService(ProductsRepository productsRepository) {
		super();
		this.productsRepository = productsRepository;
	}
	



	public List<Products> findAll() {
		return productsRepository.findAll();
	}


	public Products findById(Long id) {
			Optional<Products> optionalProducts = productsRepository.findById(id);
			return optionalProducts.orElse(null);
		}




}
