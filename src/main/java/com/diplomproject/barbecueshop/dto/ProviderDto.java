package com.diplomproject.barbecueshop.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProviderDto extends GenericDto {

    private String title;
    private String description;
    private String phone;
    private Set<Long> productsIds;
}

