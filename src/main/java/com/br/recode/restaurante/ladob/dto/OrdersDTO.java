package com.br.recode.restaurante.ladob.dto;

import java.util.List;

public class OrdersDTO extends OrdersBaseDTO {

	private TablesBaseDTO table;
	private CostumersBaseDTO costumer;
	private List<ProductOrderBaseDTO> productOrders;
}
