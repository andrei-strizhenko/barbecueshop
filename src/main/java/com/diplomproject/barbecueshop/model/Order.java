package com.diplomproject.barbecueshop.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "orders_seq", allocationSize = 1)

public class Order extends GenericModel {

    //  @Id
    //   @Column(name = "id")
    //  private Long id;

    // @SuppressWarnings("JpaDataSourceORMInspection")
    @OneToOne(fetch = FetchType.LAZY) // добавил каскад тип
    private DeliveryOrder deliveryOrder;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "FK_USER_PRO")
    )
    private User user;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // заменил связь через таблицу orderInfo
    //   @JsonIgnore  // убирает рекурсию пока нет ДТО
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            //     foreignKey = @ForeignKey(name = "FK_ORDERS_PRODUCTS"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
            //      inverseForeignKey = @ForeignKey(name = "FK_PRODUCTS_ORDERS")
    )
    private List<Product> products = new ArrayList<>();



    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    //  @JsonIgnore // убирает рекурсию
    @JoinTable(
            name = "orders_providers",
            joinColumns = @JoinColumn(name = "order_id"),
            foreignKey = @ForeignKey(name = "FK_ORDERS_PROVIDERS"),
            inverseJoinColumns = @JoinColumn(name = "provider_id"),
            inverseForeignKey = @ForeignKey(name = "FK_PROVIDERS_ORDERS"))
    private List<Provider> providers = new ArrayList<>();


    @Column(name = "user_surname")
    private String userSurname;

    @Column(name = "total")
    private Double total;


    @Builder

    public Order(Long id, Double total, List<Product> products, List<Provider> providers, String createdBy, String userSurname, User user, DeliveryOrder deliveryOrder) {
        super(id, createdBy);
        //      this.orderDateTime = orderDateTime;
        //     this.deliveryDateTime = deliveryDateTime;
        this.deliveryOrder = deliveryOrder;
        //     this.purchase = purchase;
        this.total = total;
        this.user = user;
        this.userSurname = userSurname;
        this.products = products;
        this.providers = providers;


    }



}
