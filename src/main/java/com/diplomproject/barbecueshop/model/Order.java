package com.diplomproject.barbecueshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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





    //   @Column(name = "order_time")
    //   private LocalDateTime orderDateTime;

//    @Column(name = "delivery_time")
    //   private LocalDateTime deliveryDateTime;


    // @SuppressWarnings("JpaDataSourceORMInspection")
 /*   @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // добавил каскад тип
    @JoinColumn(
            name = "delivery_order_id",
            foreignKey = @ForeignKey(name = "FK_ORDERS_DELIVERY_ORDER")
    )
    private DeliveryOrder deliveryOrder;*/


    //  @Column(name = "purchase")
    //   private boolean purchase;


  /*  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "FK_USER_PRO")
    )
    private User user; */


       @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // заменил связь через таблицу orderInfo
       @JsonIgnore  // убирает рекурсию пока нет ДТО
       @JoinTable(
               name = "orders_products",
               joinColumns = @JoinColumn(name ="order_id" ),
               foreignKey = @ForeignKey(name = "FK_ORDERS_PRODUCTS"),
               inverseJoinColumns = @JoinColumn(name ="product_id"),
               inverseForeignKey = @ForeignKey(name = "FK_PRODUCTS_ORDERS")
       )
       private Set<Product> products= new HashSet<>();


 //   @Column(name = "user_surname")
  //  private String userSurname;

    @Column(name = "total")
    //  private DecimalFormat total;
    private Double total;


  //  @JsonManagedReference
 //  @OneToMany(mappedBy = "orders")
  //  @Valid
  //  @Column(name = "products")
  //  private List<Product> products = new ArrayList<>();

    //   @ManyToOne(fetch = FetchType.LAZY)
    //   @JoinColumn(name = "user_id", nullable = false,
    //           foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORD_FK"))
    //   private User user;


  /*  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false,
            foreignKey = @ForeignKey(name = "ORDER_DETAIL_PROD_FK"))
    private Product product;*/


 //   @Column(name = "quantity", nullable = false)
 //   private Integer quantity;


    @Builder

    public Order(Long id, Double total, Set<Product> products) {
        super(id);
  //      this.orderDateTime = orderDateTime;
   //     this.deliveryDateTime = deliveryDateTime;
   //     this.deliveryOrder = deliveryOrder;
   //     this.purchase = purchase;
        this.total = total;
        // this.products = products;
    //    this.user = user;
    //    this.userSurname = userSurname;
      this.products = products;
   //     this.product = product;

     //   this.quantity = quantity;
        //   this.listIdOrderedProducts =listIdOrderedProducts;
    }

}
