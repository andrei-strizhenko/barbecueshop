package com.diplomproject.barbecueshop.dto;

import lombok.Data;

import java.util.List;

@Data
public class AddIdProductInListDto {
    private List<Long> listIdOrderedProducts;
}
