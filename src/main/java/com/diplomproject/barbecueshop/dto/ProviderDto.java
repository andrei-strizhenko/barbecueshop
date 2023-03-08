package com.diplomproject.barbecueshop.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProviderDto extends GenericDto {
    private String title;
    private String description;
    private String phone;
    private String productName;
    private Long amount;
    private Double cost;
    private List<Long> ordersIds;
}

