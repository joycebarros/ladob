package com.br.recode.restaurante.ladob.service;

import org.springframework.stereotype.Service;
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

}
