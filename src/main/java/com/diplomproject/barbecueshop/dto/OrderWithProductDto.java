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

public class OrderWithProductDto extends OrderDto {
  //  private Set<ProductDto> products;
    private List<ProductDto> products;
}
