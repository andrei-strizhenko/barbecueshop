package com.diplomproject.barbecueshop.model;

import lombok.*;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "orders_seq", allocationSize = 1)

public class Order extends GenericModel{

    //  @Id
    //   @Column(name = "id")
    //  private Long id;

    @Column(name = "order_time")
    private LocalDateTime orderDateTime;

    @Column(name = "delivery_time")
    private LocalDateTime deliveryDateTime;


   // @SuppressWarnings("JpaDataSourceORMInspection")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // добавил каскад тип
    @JoinColumn(
            name = "delivery_order_id",
            foreignKey = @ForeignKey(name = "FK_ORDERS_DELIVERY_ORDER")
    )
    private DeliveryOrder deliveryOrder;



    @Column(name = "purchase")
    private boolean purchase;

    @Column(name = "cost")
    private DecimalFormat cost;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "FK_USERS_PRODUCTS")
    )
    private User user;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "provider_id",
            foreignKey = @ForeignKey(name = "FK_PROVIDERS_PRODUCTS")
    )
    private Provider provider;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "product_id",
            foreignKey = @ForeignKey(name = "FK_PRODUCTS_USERS")
    )
    private Product product;

    @Builder

    public Order(Long id, LocalDateTime orderDateTime, LocalDateTime deliveryDateTime, DeliveryOrder deliveryOrder, boolean purchase, DecimalFormat cost, User user, Provider provider, Product product) {
        super(id);
        this.orderDateTime = orderDateTime;
        this.deliveryDateTime = deliveryDateTime;
        this.deliveryOrder = deliveryOrder;
        this.purchase = purchase;
        this.cost = cost;
        this.provider = provider;
        this.product = product;
        this.user = user;
    }

}
