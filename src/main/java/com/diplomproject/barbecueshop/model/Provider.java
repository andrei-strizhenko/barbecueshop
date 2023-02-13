package com.diplomproject.barbecueshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "providers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "users_seq", allocationSize = 1)
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
}
