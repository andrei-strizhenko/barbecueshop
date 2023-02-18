package com.diplomproject.barbecueshop.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddProductInOrderDto {

    Double total;
 //   @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDateTime deliveryDateTime;
    Long productId;
    Long orderId;
}

