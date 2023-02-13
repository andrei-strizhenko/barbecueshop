package com.diplomproject.barbecueshop.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.text.DecimalFormat;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto extends GenericDto {
    @NotBlank(message = "Поле не должно быть пустым")
    private String title;
    @NotBlank(message = "Поле не должно быть пустым")
    private String description;
    @NotBlank(message = "Поле не должно быть пустым")
    private double cost;
    @NotBlank(message = "Поле не должно быть пустым")
    private double discount;
    @NotBlank(message = "Поле не должно быть пустым")
    private String image;
    @NotBlank(message = "Поле не должно быть пустым")
    private Long available;
    @NotBlank(message = "Поле не должно быть пустым")
    private Long ordered;
    private Set<Long> providersIds;

}
