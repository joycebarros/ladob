package com.br.recode.restaurante.ladob.controller.mapper;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.br.recode.restaurante.ladob.dto.ProductsBaseDTO;
import com.br.recode.restaurante.ladob.dto.ProductsDTO;
import com.br.recode.restaurante.ladob.model.Products;

@Component
public class ProductsMapper {

	private ModelMapper modelMapper;
	
	public ProductsMapper() {
		this.modelMapper = new ModelMapper();
	}
	
	public List<ProductsBaseDTO> toProductsBaseDTO (List<Products> products){
		List<ProductsBaseDTO> productsBaseDTO = new ArrayList<>();
		for (Products product : products) {
			productsBaseDTO.add(toProductsBaseDTO(product));
		}
		return productsBaseDTO;
	}
	
	public ProductsBaseDTO toProductsBaseDTO (Products products) {
		return modelMapper.map(products, ProductsBaseDTO.class);
	}
	
	public ProductsDTO toProductsDTO (Products products) {
		return modelMapper.map(products, ProductsDTO.class);
	}
	
	public Products toProducts (ProductsBaseDTO productsBaseDTO) {
		return modelMapper.map(productsBaseDTO, Products.class);
	}
}
