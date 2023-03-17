package com.diplomproject.barbecueshop.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "providers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "providers_seq", allocationSize = 1)
public class Provider extends GenericModel {

        //  @Id
        //  @Column(name = "id")
        //   private Long id;



        @Column(name = "name")
        private String title;

        @Column(name = "description")
        private String description;

        @Column(name = "phone")
        private String phone;

        @Column(name = "product_name")
        private String productName;

        @Column(name = "amount")
        private Long amount;

        @Column(name = "cost")
        private Double cost;

        @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
        //   @JsonIgnore // убирает рекурсию
        @JoinTable(
                name = "products_providers",
                joinColumns = @JoinColumn(name = "provider_id"),
                foreignKey = @ForeignKey(name = "FK_PROVIDERS_PRODUCTS"),
                inverseJoinColumns = @JoinColumn(name = "product_id"),
                inverseForeignKey = @ForeignKey(name = "FK_PRODUCTS_PROVIDERS"))
        private Set<Product> products = new HashSet<>();


        @Builder
        public Provider(Long id, String createdBy, String title, String description, String phone, String productName, Long amount, Double cost, Set<Product> products) {
                super(id, createdBy);
                this.title = title;
                this.description = description;
                this.phone = phone;
                this.productName = productName;
                this.amount = amount;
                this.cost = cost;
                this.products = products;
        }

}
