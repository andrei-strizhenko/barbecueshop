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

public class OrderDto extends GenericDto {

    //   private Long productId;
    //   private Long userId;
    //   private UserDto user;
    //   private ProductDto product;
    private Double total;
    private Integer quantity;
    private List<Long> productsIds;


    //  private List<Long> listIdOrderedProducts;


}
