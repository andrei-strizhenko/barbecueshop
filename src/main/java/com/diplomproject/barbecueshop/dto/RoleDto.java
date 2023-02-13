package com.diplomproject.barbecueshop.dto;

import com.diplomproject.barbecueshop.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleDto {

    private Long id;
    private String title;
    private String description;


    public RoleDto (Role role) {
        this.id = role.getId();
        this.title = role.getTitle();
        this.description = role.getDescription();
    }
}
