package com.diplomproject.barbecueshop.dto;


import lombok.Data;

import java.util.Set;

@Data
public class ProductWithProviderDto extends ProductDto{
    private Set<ProviderDto> providers;
}
