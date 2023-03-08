package com.diplomproject.barbecueshop.model;

import javax.persistence.Column;
import java.time.LocalDateTime;

import lombok.*;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Collection;

@Entity
@Table(name = "delivery_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "orders_seq", allocationSize = 1)
public class DeliveryOrder extends GenericModel {


    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "delivery_order_time")
    private LocalDateTime deliveryOrderDateTime;

    @Column(name = "delivery_time")
    private LocalDateTime deliveryDateTime;

    @Column(name = "status")
    private String image;

    @Column(name = "cost")
    private double cost;

    @Column(name = "purchase")
    private boolean purchase;


}

