package com.br.recode.restaurante.ladob.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.br.recode.restaurante.ladob.model.ProductOrder;
import com.br.recode.restaurante.ladob.repository.ProductOrderRepository;

@Service
public class ProductOrderService {

	private ProductOrderRepository productOrderRepository;

	public ProductOrderService(ProductOrderRepository productOrderRepository) {
		super();
		this.productOrderRepository = productOrderRepository;
	}

	public List<ProductOrder> findAll() {
		return productOrderRepository.findAll();
	}

	public ProductOrder findById(Long id) {
		Optional<ProductOrder> optionalProductOrder = productOrderRepository.findById(id);
		return optionalProductOrder.orElse(null);
	}

	public ProductOrder save(ProductOrder productOrder) {
		productOrder.setId(null);
		return internalSave(productOrder);
	}

	public ProductOrder update(ProductOrder productOrder) {
		Long id = productOrder.getId();
		if (id == null) {
			return null;
		}
		if (!productOrderRepository.existsById(id)) {
			return null;
		}
		return internalSave(productOrder);
	}

	public void deleteById(Long id) {
		try {
			productOrderRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}

	public void deleteAll() {
		productOrderRepository.deleteAllInBatch();
	}

	public ProductOrder internalSave(ProductOrder productOrder) {
		try {
			return productOrderRepository.save(productOrder);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
