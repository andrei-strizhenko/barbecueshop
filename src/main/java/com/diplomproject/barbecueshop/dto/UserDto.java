package com.diplomproject.barbecueshop.dto;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends GenericDto{

 //   private RoleDto role;
    private String name;
    private String surname;
    private String login;
    private String password;
    private String birthDate;
    private String email;
    private String phone;
    private String address;
}
