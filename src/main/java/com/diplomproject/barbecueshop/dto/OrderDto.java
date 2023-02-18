package com.diplomproject.barbecueshop.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderDto extends GenericDto {


    private Long productId;
    private UserDto user;

    @NotBlank(message = "Поле не должно быть пустым")
    private Double total;
 //  @NotBlank(message = "Поле не должно быть пустым")
 //   private Long userId;



/*    @NotBlank(message = "Поле не должно быть пустым")
    private double discount;
    @NotBlank(message = "Поле не должно быть пустым")
    private String image;
    @NotBlank(message = "Поле не должно быть пустым")
    private Long available;
    @NotBlank(message = "Поле не должно быть пустым")
    private Long ordered;*/
    private Set<Long> productsIds;


}
