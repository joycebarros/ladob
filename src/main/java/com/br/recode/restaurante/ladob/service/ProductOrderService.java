package com.br.recode.restaurante.ladob.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.br.recode.restaurante.ladob.model.Orders;
import com.br.recode.restaurante.ladob.model.ProductOrder;
import com.br.recode.restaurante.ladob.model.Products;
import com.br.recode.restaurante.ladob.repository.ProductOrderRepository;

@Service
public class ProductOrderService {

	private ProductOrderRepository productOrderRepository;
	private OrdersService ordersService;
	private ProductsService productsService;

	public ProductOrderService(ProductOrderRepository productOrderRepository, OrdersService ordersService, ProductsService productsService) {
		super();
		this.productOrderRepository = productOrderRepository;
		this.ordersService = ordersService;
		this.productsService = productsService;
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
		try {
			productOrder = productOrderRepository.save(productOrder);
			Orders orders = ordersService.findById(productOrder.getOrders().getId());
			productOrder.setOrders(orders);
			Products products = productsService.findById(productOrder.getProducts().getId());
			productOrder.setProducts(products);
			return productOrder;
		}catch (Exception e) {
			return null;
		}
		
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
