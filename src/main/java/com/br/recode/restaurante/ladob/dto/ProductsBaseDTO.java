package com.br.recode.restaurante.ladob.dto;

public class ProductsBaseDTO {

	private Long id;
	private String product;
	private Double unitPrice;
	private ProductOrderBaseDTO productOrder;
	
	public ProductsBaseDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public ProductOrderBaseDTO getProductOrder() {
		return productOrder;
	}
	public void setProductOrder(ProductOrderBaseDTO productOrder) {
		this.productOrder = productOrder;
	}
	
	
}
