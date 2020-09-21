package com.br.recode.restaurante.ladob.service;

import java.util.List;
import java.util.Optional;

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
		return productOrderRepository.save(productOrder);
	}

	public ProductOrder update(ProductOrder productOrder) {
		Long id = productOrder.getId();
		if(id == null) {
			return null;
		}else {
			ProductOrder findProductOrder = productOrderRepository.findById(id).orElse(null);
			if(findProductOrder == null) {
				return null;
			}
			return productOrderRepository.save(productOrder);
		}		
	}

	public void deleteById(Long id) {
		productOrderRepository.deleteById(id);
		
	}
	
	
}
