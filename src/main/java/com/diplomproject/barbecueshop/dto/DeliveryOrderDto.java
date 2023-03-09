package com.diplomproject.barbecueshop.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeliveryOrderDto extends GenericDto{


    private LocalDateTime deliveryOrderDateTime;
    private LocalDateTime deliveryDateTime;
    private String image;
    private double cost;
    private boolean purchase;
    private String status;

  //  private List<Long> ordersIds;
}
