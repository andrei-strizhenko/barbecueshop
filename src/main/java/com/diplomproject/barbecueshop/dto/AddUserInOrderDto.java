package com.diplomproject.barbecueshop.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AddUserInOrderDto {
    Long userId;
   Long orderId;
   private LocalDateTime orderDateTime;
}
