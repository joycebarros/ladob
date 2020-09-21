package com.br.recode.restaurante.ladob.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.recode.restaurante.ladob.model.Products;
import com.br.recode.restaurante.ladob.repository.ProductsRepository;

@Service
public class ProductsService {
	
	private ProductsRepository productsRepository;
	
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


	public Products save(Products products) {
		return productsRepository.save(products);
	}


	public Products update(Products products) {
		Long id = products.getId();
		if(id == null) {
			return null;
		}else {
			Products findProducts = productsRepository.findById(id).orElse(null);
			if(findProducts == null) {
				return null;
			}
			return productsRepository.save(products);
		}		
	}


	public void deleteById(Long id) {
		productsRepository.deleteById(id);
		
	}


}
