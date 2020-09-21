package com.br.recode.restaurante.ladob.controller.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.br.recode.restaurante.ladob.dto.ProductOrderBaseDTO;
import com.br.recode.restaurante.ladob.dto.ProductOrderDTO;
import com.br.recode.restaurante.ladob.model.ProductOrder;

@Component
public class ProductOrderMapper {

	private ModelMapper modelMapper;

	public ProductOrderMapper() {
		this.modelMapper = new ModelMapper();
	}

	public List<ProductOrderBaseDTO> toProductOrderBaseDTO(List<ProductOrder> productOrders) {
		List<ProductOrderBaseDTO> productOrdersBaseDTO = new ArrayList<>();

		for (ProductOrder productOrder : productOrders) {
			productOrdersBaseDTO.add(toProductOrderBaseDTO(productOrder));
		}
		return productOrdersBaseDTO;
	}

	public ProductOrderBaseDTO toProductOrderBaseDTO(ProductOrder productOrder) {
		return modelMapper.map(productOrder, ProductOrderBaseDTO.class);
	}

	public ProductOrderDTO toProductOrderDTO(ProductOrder productOrder) {
		return modelMapper.map(productOrder, ProductOrderDTO.class);
	}

	public ProductOrder toProductOrder(ProductOrderBaseDTO productOrdersBaseDTO) {
		return modelMapper.map(productOrdersBaseDTO, ProductOrder.class);
	}
}
