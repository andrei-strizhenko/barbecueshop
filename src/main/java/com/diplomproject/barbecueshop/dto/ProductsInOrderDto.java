package com.diplomproject.barbecueshop.dto;

import com.diplomproject.barbecueshop.model.Order;
import com.diplomproject.barbecueshop.model.Product;
import lombok.Data;

@Data
public class ProductsInOrderDto {
    private Order order;
    private Product product;
    private Integer quantity;
    private Double cost;
}
