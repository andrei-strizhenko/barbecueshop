package com.diplomproject.barbecueshop.dto;

import lombok.Data;
import java.util.Set;
@Data
public class ProviderWithProductDto extends ProviderDto {
    private Set<ProductDto> products;
}




