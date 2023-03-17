package com.diplomproject.barbecueshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductWithOrderDto extends ProductDto {

    private List<OrderDto> orders;
}
