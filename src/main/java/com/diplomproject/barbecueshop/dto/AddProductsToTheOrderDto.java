package com.diplomproject.barbecueshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddProductsToTheOrderDto extends GenericDto{
private Long productId;
private Long orderId;
}
