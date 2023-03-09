package com.diplomproject.barbecueshop.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

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
    // private User user;
    private String surname;
    private List<Long> productsIds;
    private Set<Long> ordersIds;

    //  private List<Long> listIdOrderedProducts;


}
