package com.diplomproject.barbecueshop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.relational.core.sql.NumericLiteral;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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
    private DecimalFormat cost;

 //   @Column(name = "genre")
 //   @Enumerated
 //   private Genre genre;

    @Column(name = "discount")
    private String discount;

    @Column(name = "image")
    private String image;

    @Column(name = "available")
    private Long available;

    @Column(name = "ordered")
    private Long ordered;


    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    // @JsonIgnore // убирает рекурсию
    @JoinTable(
            name = "products_users",
            joinColumns = @JoinColumn(name = "product_id"),
            foreignKey = @ForeignKey(name = "FK_PRODUCTS_USERS"),
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            inverseForeignKey = @ForeignKey(name = "FK_USERS_PRODUCTS"))
    private Set<User> users = new HashSet<>();

    @Builder
    public Product(Long id, String title, String description, DecimalFormat cost, String discount, String image, Long available, Long ordered, Set<User> users) {
        super(id);
        this.title = title;
        this.description = description;
        this.cost = cost;
        this.discount = discount;
        this.image = image;
        this.available = available;
        this.ordered = ordered;
        this.users = users;
    }
}