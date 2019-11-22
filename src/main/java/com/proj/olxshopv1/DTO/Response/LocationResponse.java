package com.proj.olxshopv1.DTO.Response;

import com.proj.olxshopv1.Entity.LocationEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
@Getter
@Setter
public class LocationResponse {
    private String titleOfCity;
    private String titleOfStreet;
    private int numberOfHouse;
    private int numberOfFlat;
    private Long id;


    private List<CommodityResponse> commodities;
public LocationResponse(){}
    public LocationResponse(LocationEntity locationEntity){
        this.titleOfCity=locationEntity.getTitleOfCity();
        this.titleOfStreet=locationEntity.getTitleOfStreet();
        this.numberOfHouse=locationEntity.getNumberOfHouse();
        this.numberOfFlat=locationEntity.getNumberOfFlat();
        this.id = locationEntity.getId();
        this.commodities = locationEntity.getCommodities()
                .stream().map(CommodityResponse::new).collect(Collectors.toList());
    }
}
