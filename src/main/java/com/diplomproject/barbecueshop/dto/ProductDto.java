package com.diplomproject.barbecueshop.dto;

import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto extends GenericDto {
  //  @NotBlank(message = "Поле не должно быть пустым")
    private String title;
//    @NotBlank(message = "Поле не должно быть пустым")
 //   private String description;
//    @NotBlank(message = "Поле не должно быть пустым")
    private Double cost;
 //   @NotBlank(message = "Поле не должно быть пустым")
  //  private double discount;
  //  @NotBlank(message = "Поле не должно быть пустым")
  //  private String image;
 //   @NotBlank(message = "Поле не должно быть пустым")
  //  private Long available;
  //  @NotBlank(message = "Поле не должно быть пустым")
 //   private Long ordered;

  //  private Long orderId;
   private List<Long> ordersIds;
    private Set<Long> providersIds;
 //   private Long productId;
// private Long amount;
  //  private Long totalSum;
}
