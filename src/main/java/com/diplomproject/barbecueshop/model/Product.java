package com.diplomproject.barbecueshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

import java.util.HashSet;
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
    private double cost;

 //   @Column(name = "genre")
 //   @Enumerated
 //   private Genre genre;

    @Column(name = "discount")
    private double discount;

    @Column(name = "image")
    private String image;

    @Column(name = "available")
    private Long available;

    @Column(name = "ordered")
    private Long ordered;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
     @JsonIgnore // убирает рекурсию
    @JoinTable(
            name = "products_providers",
            joinColumns = @JoinColumn(name = "product_id"),
            foreignKey = @ForeignKey(name = "FK_PRODUCTS_PROVIDERS"),
            inverseJoinColumns = @JoinColumn(name = "provider_id"),
            inverseForeignKey = @ForeignKey(name = "FK_PROVIDERS_PRODUCTS"))
    private Set<Provider> providers = new HashSet<>();

    @Builder
    public Product(Long id, String title, String description, double cost, double discount, String image, Long available, Long ordered, Set<Provider> providers) {
        super(id);
        this.title = title;
        this.description = description;
        this.cost = cost;
        this.discount = discount;
        this.image = image;
        this.available = available;
        this.ordered = ordered;
        this.providers = providers;
    }
}