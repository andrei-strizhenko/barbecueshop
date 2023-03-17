package com.diplomproject.barbecueshop.model;


import lombok.*;

import javax.persistence.*;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "role_id",
            foreignKey = @ForeignKey(name = "FK_USER_ROLES")
    )
    private Role role;

    @Column(name = "is_deleted")
    private boolean isDeleted;


    @Column(name = "change_password_token")
    private String changePasswordToken;


//    // @SuppressWarnings("JpaDataSourceORMInspection")
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(
//            name = "delivery_order_id",
//            foreignKey = @ForeignKey(name = "FK_USERS_DELIVERY_ORDER")
//    )
//    private DeliveryOrder deliveryOrder;

    @OneToMany(mappedBy = "user")
    private Set<Order> orders;

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
                //  ", deliveryOrder=" + deliveryOrder +
                '}';
    }

    @Builder
    public User(Long id, String login, String password, String name, String surname,
                String birthDate, String phone, String address, String email, Role role, boolean isDeleted, String createdBy,/* DeliveryOrder deliveryOrder,*/ Set<Order> orders) {
        super(id, createdBy);
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.role = role;
        this.isDeleted = isDeleted;
        //   this.deliveryOrder = deliveryOrder;
        this.orders = orders;

    }

}
