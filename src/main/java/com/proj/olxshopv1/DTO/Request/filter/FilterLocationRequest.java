package com.proj.olxshopv1.DTO.Request.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterLocationRequest {

    private Integer numberOfHouseFrom;
    private Integer numberOfHouseTo;
    private Integer numberOfFlatFrom;
    private Integer numberOfFlatTo;
    private String titleOfCity;
    private String titleOfStreet;

}
