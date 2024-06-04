package com.craftshop.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class AddressDto {
    private String street;
    private int building;
    private int numberApartment;
    private String indexNum;
    private String country;
    private String city;
}
