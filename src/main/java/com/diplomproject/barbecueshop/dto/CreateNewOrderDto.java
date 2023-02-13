package com.diplomproject.barbecueshop.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateNewOrderDto extends GenericDto {
    private LocalDateTime orderDateTime;

}
