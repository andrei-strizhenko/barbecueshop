package com.diplomproject.barbecueshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "providers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "users_seq", allocationSize = 1)
public class Provider extends GenericModel {

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
                name = "orders_providers",
                joinColumns = @JoinColumn(name = "provider_id"),
                foreignKey = @ForeignKey(name = "FK_PROVIDERS_ORDERS"),
                inverseJoinColumns = @JoinColumn(name = "order_id"),
                inverseForeignKey = @ForeignKey(name = "FK_ORDERS_PROVIDERS"))
        private Set<Order> orders = new HashSet<>();


}
