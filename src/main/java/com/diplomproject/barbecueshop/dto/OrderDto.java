package com.diplomproject.barbecueshop.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderDto extends GenericDto {

    private double cost;
    private Long productId;
    private Long userId;
    private ProductDto product;
    private UserDto user;

}
