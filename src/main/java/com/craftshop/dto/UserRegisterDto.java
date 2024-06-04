package com.craftshop.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class UserRegisterDto {
    private String email;
    public String firstName;
    private String lastName;
    private String password;
}
