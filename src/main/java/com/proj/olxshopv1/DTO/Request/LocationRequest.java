package com.proj.olxshopv1.DTO.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationRequest {
    private String titleOfCity;
    private String titleOfStreet;
    private int numberOfHouse;
    private int numberOfFlat;


    public LocationRequest(){}
}
