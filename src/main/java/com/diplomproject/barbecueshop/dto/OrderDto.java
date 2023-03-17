package com.diplomproject.barbecueshop.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderDto extends GenericDto {


    private Double total;
    private String surname;
    private List<Long> productsIds;
    //private Set<Long> ordersIds;




}
