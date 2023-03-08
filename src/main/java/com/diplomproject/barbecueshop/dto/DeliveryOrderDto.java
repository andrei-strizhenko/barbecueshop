package com.diplomproject.barbecueshop.dto;

import java.time.LocalDateTime;

public class DeliveryOrderDto extends GenericDto{


    private LocalDateTime deliveryOrderDateTime;
    private LocalDateTime deliveryDateTime;
    private String image;
    private double cost;
    private boolean purchase;
    private String status;

  //  private List<Long> ordersIds;
}
