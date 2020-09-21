package com.br.recode.restaurante.ladob.dto;

import java.util.List;

public class ProductsDTO extends ProductsBaseDTO {
	
	private List<ProductOrderBaseDTO> productOrder;
	
	public ProductsDTO() {
		
	}

	public List<ProductOrderBaseDTO> getProductOrder() {
		return productOrder;
	}

	public void setProductOrder(List<ProductOrderBaseDTO> productOrder) {
		this.productOrder = productOrder;
	}
	
	

}
