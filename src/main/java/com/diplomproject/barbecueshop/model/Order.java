package com.diplomproject.barbecueshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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

    @Column(name = "total")
  //  private DecimalFormat total;
    private Double total;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "FK_USER_PRO")
    )
    private User user;

    @Column(name = "user_surname")
    private String userSurname;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore  // убирает рекурсию пока нет ДТО
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name ="order_id" ),
            foreignKey = @ForeignKey(name = "FK_ORDERS_PRODUCTS"),
            inverseJoinColumns = @JoinColumn(name ="product_id"),
            inverseForeignKey = @ForeignKey(name = "FK_PRODUCTS_ORDERS")
    )
    private Set<Product> products= new HashSet<>();

    @Builder

    public Order(Long id, LocalDateTime orderDateTime, LocalDateTime deliveryDateTime, DeliveryOrder deliveryOrder, boolean purchase, Double total, User user, String userSurname, Set<Product> products) {
        super(id);
        this.orderDateTime = orderDateTime;
        this.deliveryDateTime = deliveryDateTime;
        this.deliveryOrder = deliveryOrder;
        this.purchase = purchase;
        this.total = total;
        this.products = products;
        this.user = user;
        this.userSurname = userSurname;
    }

}
