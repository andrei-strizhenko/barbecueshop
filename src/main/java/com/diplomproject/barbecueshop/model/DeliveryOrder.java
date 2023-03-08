package com.diplomproject.barbecueshop.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "orders_seq", allocationSize = 1)
public class DeliveryOrder extends GenericModel {


//    @Id
//    @Setter(AccessLevel.NONE)
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

    @Column(name = "delivery_order_time")
    private LocalDateTime deliveryOrderDateTime;

    @Column(name = "delivery_time")
    private LocalDateTime deliveryDateTime;

    @Column(name = "status")
    private String status;

    @Column(name = "cost_of_delivery")
    private double costOfDelivery;

    @Column(name = "cost_of_order")
    private double costOfOrder;

    @Column(name = "purchase")
    private boolean purchase;

    @OneToOne(fetch = FetchType.LAZY) // добавил каскад тип
    private Order order;

    @Builder
    public DeliveryOrder(Long id, String createdBy, LocalDateTime deliveryOrderDateTime, LocalDateTime deliveryDateTime, double costOfDelivery, double costOfOrder, boolean purchase, Order order, String status) {
        super(id, createdBy);
        this.deliveryOrderDateTime = deliveryOrderDateTime;
        this.deliveryDateTime = deliveryDateTime;
        this.status = status;
        this.costOfDelivery = costOfDelivery;
        this.costOfOrder = costOfOrder;
        this.purchase = purchase;
        this.order = order;

    }

}

