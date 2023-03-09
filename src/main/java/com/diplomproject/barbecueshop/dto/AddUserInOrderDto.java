package com.diplomproject.barbecueshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserInOrderDto extends GenericDto{
    private Long userId;
    private Long orderId;
}
