package com.diplomproject.barbecueshop.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateDto {
 //   private String email;
    private String login;
    private String password;

}
