package com.diplomproject.barbecueshop.dto;

import lombok.Data;

@Data
public class AddProductInOrderDto {

 //   Double total;
 //   @DateTimeFormat(pattern = "yyyy-MM-dd")
 //   LocalDateTime deliveryDateTime;
    Long productId;
    Long userId;
    Long orderId;
 //   Long orderInfoId;
    Double cost;
 //  ArrayList<ProductDto> listIdOrderedProducts;
    Integer quantity;

}

