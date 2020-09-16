package com.br.recode.restaurante.ladob.service;

import org.springframework.stereotype.Service;
import com.br.recode.restaurante.ladob.repository.ProductsRepository;

@Service
public class ProductsService {
	
	//referenciar o repositorio ao servico prodto
	private ProductsRepository productsRespository;
	
	//criacao do construtor
	public ProductsService(ProductsRepository productsRespository) {
		super();
		this.setProductsRespository(productsRespository);
	}
	

	public ProductsRepository getProductsRespository() {
		return productsRespository;
	}

	public void setProductsRespository(ProductsRepository productsRespository) {
		this.productsRespository = productsRespository;
	}
	

}
