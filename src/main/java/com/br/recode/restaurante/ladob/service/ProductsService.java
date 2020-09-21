package com.br.recode.restaurante.ladob.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.br.recode.restaurante.ladob.model.Products;
import com.br.recode.restaurante.ladob.repository.ProductsRepository;

@Service
public class ProductsService {

	private ProductsRepository productsRepository;

	public ProductsService(ProductsRepository productsRepository) {

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
		products.setId(null);
		return internalSave(products);
	}

	public Products update(Products products) {
		Long id = products.getId();
		if (id == null) {
			return null;
		}
		if (!productsRepository.existsById(id)) {
			return null;
		}
		return internalSave(products);
	}

	public void deleteById(Long id) {
		try {
			productsRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

	public void deleteAll() {
		productsRepository.deleteAllInBatch();
	}

	public Products internalSave(Products products) {
		try {
			return productsRepository.save(products);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
