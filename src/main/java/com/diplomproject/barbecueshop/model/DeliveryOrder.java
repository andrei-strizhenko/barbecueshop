package com.diplomproject.barbecueshop.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "delivery_orders_seq", allocationSize = 1)
public class DeliveryOrder extends GenericModel {


    @Column(name = "delivery_order_time")
    @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private LocalDateTime deliveryOrderDateTime;

    @Column(name = "delivery_time")
    @DateTimeFormat(fallbackPatterns = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private LocalDateTime deliveryDateTime;

    @Column(name = "status")
    private String status;

    @Column(name = "cost_of_delivery")
    private double costOfDelivery;

    @Column(name = "cost_of_order")
    private double costOfOrder;

    @Column(name = "purchase")
    private boolean purchase;

    @OneToOne(/*mappedBy = "order",*/ fetch = FetchType.LAZY, cascade = CascadeType.ALL) // добавил каскад тип
    private Order order;



    @Builder
    public DeliveryOrder(Long id, String createdBy, LocalDateTime deliveryOrderDateTime,
                         LocalDateTime deliveryDateTime, String status, double costOfDelivery, boolean purchase, double costOfOrder, Order order) {
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

