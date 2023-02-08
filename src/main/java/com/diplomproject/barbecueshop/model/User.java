package com.diplomproject.barbecueshop.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "users_seq", allocationSize = 1)
public class User extends GenericModel {
    //  @Id
    //  @Column(name = "id")
    //   private Long id;

    @Column(name ="login", nullable = false)
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // добавил каскад тип
    @JoinColumn(
            name = "role_id",
            foreignKey = @ForeignKey(name = "FK_USER_ROLES")
    )
    private Role role;





    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(
            name = "delivery_order_id",
            foreignKey = @ForeignKey(name = "FK_USERS_DELIVERY_ORDER")
    )
    private DeliveryOrder deliveryOrder;


 //   @ManyToOne(mappedBy = "users")
//    private Set<Order> orders;

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role.getId() +
                '}';
    }

    @Builder
    public User(Long id, String login, String password, String name, String surname,
                String birthDate, String phone, String address, String email, Role role, DeliveryOrder deliveryOrder) {
        super(id);
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.role = role;
        this.deliveryOrder = deliveryOrder;
       // this.orders = orders;

    }

    // public String toString(){}
/*    @ManyToOne(optional = false)
    private DeliveryOrder deliveryOrders;

    public DeliveryOrder getDeliveryOrders() {
        return deliveryOrders;
    }

    public void setDeliveryOrders(DeliveryOrder deliveryOrders) {
        this.deliveryOrders = deliveryOrders;
    }*/
}
