package com.diplomproject.barbecueshop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@SequenceGenerator(name = "default_generator", sequenceName = "films_seq", allocationSize = 1)

public class Product extends GenericModel {
    //  @Id
    //  @Column(name = "id")
    //   private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "image")
    private String image;

    @Column(name = "available")
    private Long available;

    @Column(name = "ordered")
    private Long ordered;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //   @JsonIgnore  // убирает рекурсию пока нет ДТО
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "product_id"),
            //    foreignKey = @ForeignKey(name = "FK_PRODUCTS_ORDERS"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
            //  inverseForeignKey = @ForeignKey(name = "FK_ORDERS_PRODUCTS" )
    )
    private List<Order> orders= new ArrayList<>();


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    //  @JsonIgnore // убирает рекурсию
    @JoinTable(
            name = "products_providers",
            joinColumns = @JoinColumn(name = "product_id"),
            foreignKey = @ForeignKey(name = "FK_PRODUCTS_PROVIDERS"),
            inverseJoinColumns = @JoinColumn(name = "provider_id"),
            inverseForeignKey = @ForeignKey(name = "FK_PROVIDERS_PRODUCTS"))
    private Set<Provider> providers = new HashSet<>();

    @Builder
    public Product(Long id, String title, String description, double discount, double cost, List<Order> orders, String createdBy,
                   Set<Provider> providers, String image, Long available, Long ordered) {
        super(id, createdBy);
        this.title = title;
        this.description = description;
        this.cost = cost;
        this.discount = discount;
        this.image = image;
        this.available = available;
        this.ordered = ordered;
        //     this.providers = providers;
        this.orders = orders;                     //выкл
    }


}